package controller;

import model.RoomRental;
import model.PaymentMethod;
import service.IMotelRoomService;
import service.MotelRoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "MotelRoomController", value = "/motelRoom")
public class MotelRoomController extends HttpServlet {
    private IMotelRoomService motelRoomService = new MotelRoomService();

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
            case "edit":
                editForm(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void addForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PaymentMethod> paymentMethods = motelRoomService.add(); // Lấy danh sách phương thức thanh toán
        req.setAttribute("paymentMethods", paymentMethods);
        req.getRequestDispatcher("view/addRoom.jsp").forward(req, resp);
    }

    private void searchForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/searchRoom.jsp").forward(req, resp);
    }

    private void editForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        RoomRental room = motelRoomService.f(id); // Tìm phòng theo ID
        req.setAttribute("room", room);
        List<PaymentMethod> paymentMethods = motelRoomService.findAllPaymentMethods(); // Lấy danh sách phương thức thanh toán
        req.setAttribute("paymentMethods", paymentMethods);
        req.getRequestDispatcher("view/editRoom.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoomRental> rooms = motelRoomService.findAll(); // Lấy danh sách tất cả các phòng
        req.setAttribute("rooms", rooms);
        req.getRequestDispatcher("view/roomList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            addRoom(req, resp);
        } else if ("delete".equals(action)) {
            deleteRoom(req, resp);
        } else if ("update".equals(action)) {
            updateRoom(req, resp);
        } else if ("search".equals(action)) {
            searchRooms(req, resp);
        }
    }

    private void addRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenantName = req.getParameter("tenantName");
        String phoneNumber = req.getParameter("phoneNumber");
        Date rentalStartDate = Date.valueOf(req.getParameter("rentalStartDate"));
        int paymentMethodId = Integer.parseInt(req.getParameter("paymentMethodId"));
        String notes = req.getParameter("notes");

        RoomRental newRoom = new RoomRental(tenantName, phoneNumber, rentalStartDate,
                new PaymentMethod(paymentMethodId, null), notes); // Giả sử phương thức thanh toán có tên null
        motelRoomService.add(newRoom); // Gọi phương thức thêm phòng
        resp.sendRedirect("/motelRoom"); // Chuyển hướng sau khi thêm
    }

    private void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        motelRoomService.delete(id); // Gọi phương thức xóa phòng theo ID
        resp.sendRedirect("/motelRoom"); // Chuyển hướng sau khi xóa
    }

    private void updateRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String tenantName = req.getParameter("tenantName");
        String phoneNumber = req.getParameter("phoneNumber");
        Date rentalStartDate = Date.valueOf(req.getParameter("rentalStartDate"));
        int paymentMethodId = Integer.parseInt(req.getParameter("paymentMethodId"));
        String notes = req.getParameter("notes");

        RoomRental roomToUpdate = new RoomRental(id, tenantName, phoneNumber, rentalStartDate,
                new PaymentMethod(paymentMethodId, null), notes); // Giả sử phương thức thanh toán có tên null
        motelRoomService.update(roomToUpdate); // Gọi phương thức cập nhật phòng
        resp.sendRedirect("/motelRoom"); // Chuyển hướng sau khi cập nhật
    }

    private void searchRooms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenantName = req.getParameter("tenantName");
        List<RoomRental> result = motelRoomService.searchByTenantName(tenantName); // Tìm phòng theo tên người thuê
        req.setAttribute("rooms", result);
        req.getRequestDispatcher("view/roomList.jsp").forward(req, resp);
    }
}