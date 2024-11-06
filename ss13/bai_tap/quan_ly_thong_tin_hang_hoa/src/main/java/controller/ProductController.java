package controller;


import model.Product;
import model.ProductDTO;
import service.IProductService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addForm(req, resp);
                break;
            case "search":
                searchForm(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void searchForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("view/search.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addForm(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("categories", productService.findCategory());
        try {
            req.getRequestDispatcher("view/add.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("listProduct", productService.findAll());
        req.setAttribute("categories", productService.findCategory());
        try {
            req.getRequestDispatcher("view/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "update":
                updateProduct(req, resp);
                break;
            case "search":
                searchNameProduct(req, resp);
                break;
        }
    }

    private void searchNameProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        List<ProductDTO> searchList = productService.searchName(name);
        req.setAttribute("searchList", searchList);
        try {
            req.getRequestDispatcher("view/search.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) {
        int productId = Integer.parseInt(req.getParameter("productId"));
        String code = req.getParameter("code");
        String productName = req.getParameter("productName");
        String unit = req.getParameter("unit");
        double price = Double.parseDouble(req.getParameter("price"));
        String harvestDay = req.getParameter("harvestDay");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));

        Product product = new Product(productId, code, productName, unit, price, harvestDay, categoryId);
        productService.update(product);

        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);

        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String unit = req.getParameter("unit");
        double price = Double.parseDouble(req.getParameter("price"));
        String harvestDay = req.getParameter("harvestDay");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));

        Product product = new Product(code, name, unit, price, harvestDay, categoryId);
        productService.add(product);

        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}