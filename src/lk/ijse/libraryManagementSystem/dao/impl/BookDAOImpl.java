package lk.ijse.libraryManagementSystem.dao.impl;/*
    @author Dasun
*/

import javafx.scene.control.Alert;
import lk.ijse.libraryManagementSystem.dao.BookDAO;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.entity.Book;
import lk.ijse.libraryManagementSystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {

    public boolean save(Book book) throws SQLException, ClassNotFoundException {
        if (CrudUtil.execute("INSERT INTO book VALUES (?,?,?,?,?,?,?,?)",
                book.getBookID(),
                book.getBookAvalability(),
                book.getBookName(),
                book.getBookAuthor(),
                book.getBookCategorie(),
                book.getBookRackNo(),
                book.getQyt(),
                book.getBookAddedTime())){
            new Alert(Alert.AlertType.CONFIRMATION, "book Added").show();
        } else{
            new Alert(Alert.AlertType.WARNING, "Somthing wrong").show();
        }


        return false;
    }

    public void update(Book book) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("UPDATE book SET bookAvalability = ? , bookName = ? , bookAuthor = ? , bookCategorie = ? , bookRackNo = ? , qyt = ? , bookAddedTime =?  WHERE bookID = ?",
                book.getBookAvalability(),
                book.getBookName(),
                book.getBookAuthor(),
                book.getBookCategorie(),
                book.getBookRackNo(),
                book.getQyt(),
                book.getBookAddedTime(),
                book.getBookID())){
            new Alert(Alert.AlertType.CONFIRMATION,"Book Added Successful").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Somthing Was Woring").show();

        }
    }

    public void delete(String id) throws SQLException, ClassNotFoundException {
        if( CrudUtil.execute("DELETE FROM book WHERE bookID = '"+id+"'")){
            new Alert(Alert.AlertType.CONFIRMATION,"Smthig Was Worng").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"MemberDTO Delete Successful").show();

        }
    }

    public Book search(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM book WHERE bookID = '"+id+"'");
        if(result.next()){
            return new Book(
                    result.getString("bookID"),
                    result.getString("bookAvalability"),
                    result.getString("bookName"),
                    result.getString("bookAuthor"),
                    result.getString("bookCategorie"),
                    result.getString("bookRackNo"),
                    result.getString("qyt"),
                    result.getString("bookAddedTime"));

        }
        return null;
    }


    public static ArrayList<String> lodeSupplierId() throws SQLException, ClassNotFoundException { // supplyer id loding to combo box
        String sql = "SELECT supplierID FROM supplier";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();
        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }


//    public static ObservableList<Book> searchAllBooks() throws SQLException, ClassNotFoundException {
//        ObservableList<Book> list = FXCollections.observableArrayList();
//        String sql = "SELECT * FROM book";
//        ResultSet result = CrudUtil.execute(sql);
//        while (result.next()){
//            Book book = new Book(
//                    result.getString(1),
//                    result.getString(2),
//                    result.getString(3),
//                    result.getString(4),
//                    result.getString(5),
//                    result.getString(6),
//                    result.getString(7),
//                    result.getString(8));
//            list.add(book);
//        }
//        return list;
//    }

    public static BookDTO findRackNo(String id) throws SQLException, ClassNotFoundException {
        ResultSet execute = CrudUtil.execute("SELECT * FROM book WHERE  bookID = ?",id);
        if (execute.next()){
            return new BookDTO(
              execute.getString(1),
              execute.getString(2),
              execute.getString(3),
              execute.getString(4),
              execute.getString(5),
              execute.getString(6),
              execute.getString(7),
              execute.getString(8)
            );
        }
        return null;
    }

    public  String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT bookID FROM book ORDER BY bookID DESC LIMIT 1");
        if(result.next()){
            return generateNextBookId(result.getString(1));
        }
        return generateNextBookId(result.getString(null));
    }

    private  String generateNextBookId(String currentMemberId) {
        if(currentMemberId != null){
            String[] split = currentMemberId.split("B0");
            int id = Integer.parseInt(split[1]);
            id+=1;
            return "B0" + id;
        }
        return "B001";
    }








}
