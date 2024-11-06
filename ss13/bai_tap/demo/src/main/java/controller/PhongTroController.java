package controller;

import model.PhongTro;
import service.IPhongTroService;
import service.PhongTroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = "/phongtro")
public class PhongTroController extends HttpServlet {
    IPhongTroService phongTroService = new PhongTroService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "xoa":
                deletePhongTro(req, resp);

                break;

            default:
                getAllPhongTro(req, resp);
                break;
        }
    }

    private void deletePhongTro(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("ma"));
        phongTroService.deletePhongTro(id);
        resp.sendRedirect("/phongtro");
    }

    private void addPhongTro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenPhongTro = req.getParameter("tenNguoiThue");
        int soDienThoai = Integer.parseInt(req.getParameter("soDienThoai"));
        String dateString = req.getParameter("ngayThue");  // Chuỗi ngày bạn muốn chuyển đổi
        java.sql.Date ngayThue = java.sql.Date.valueOf(dateString);
        String hinhThucThue = req.getParameter("hinhThucThue");
        int ma = 0;
        if (hinhThucThue.equals("theo_thang")) {
            ma = 1;
        } else if (hinhThucThue.equals("theo_quy")) {
            ma = 2;
        } else {
            ma = 3;
        }

        String ghiChu = req.getParameter("ghiChu");
        phongTroService.addPhongTro(new PhongTro(tenPhongTro, soDienThoai, ngayThue, ma, ghiChu));
        resp.sendRedirect("/phongtro");
    }

    private void getAllPhongTro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("phongTros", phongTroService.getAllPhongTro());
        req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "timTheoTen":
                timTheoTen(req, resp);
                break;

            case "add":
                addPhongTro(req, resp);
                break;
            default:
                getAllPhongTro(req, resp);
                break;
        }
    }

    private void timTheoTen(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenPhongTro = req.getParameter("tenNguoiThue");
        req.setAttribute("phongTros", phongTroService.timTheoTen(tenPhongTro));
        req.getRequestDispatcher("/view/search.jsp").forward(req, resp);
    }

}
