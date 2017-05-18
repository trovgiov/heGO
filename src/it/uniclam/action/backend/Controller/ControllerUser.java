package it.uniclam.action.backend.Controller;

import com.opensymphony.xwork2.Action;
import it.uniclam.action.backend.Crud.CrudDao;
import it.uniclam.model.User;

import java.util.List;

public class ControllerUser {

    private CrudDao dao = new CrudDao();

    private List<User> records;
    private String result;
    private String message;
    private User record;

    private int idUser;
    private String nome;
    private String cognome;
    private String email;
    private int point;
    private String login_type;

    public CrudDao getDao() {
        return dao;
    }

    public void setDao(CrudDao dao) {
        this.dao = dao;
    }

    public List<User> getRecords() {
        return records;
    }

    public void setRecords(List<User> records) {
        this.records = records;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getRecord() {
        return record;
    }

    public void setRecord(User record) {
        this.record = record;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getLogin_type() {
        return login_type;
    }

    public void setLogin_type(String login_type) {
        this.login_type = login_type;
    }

    public String list() {
        try {
            // Fetch Data from People Table
            records = dao.getAllPeople();
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }

	/*
	public String create() throws IOException {
		record = new Student();

		record.setStudentId(studentId);
		record.setName(name);
		record.setDepartment(department);
		record.setEmailId(emailId);

		try {
			// Create new record
			dao.addStudent(record);
			result = "OK";

		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}


	*/

	/*
	public String update() throws IOException {
		Student student = new Student();

		student.setStudentId(studentId);
		student.setName(name);
		student.setDepartment(department);
		student.setEmailId(emailId);

		try {
			// Update existing record
			dao.updateStudent(student);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}


	*/


	/*
	public String delete() throws IOException {
		// Delete record
		try {
			dao.deleteStudent(studentId);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

*/
}