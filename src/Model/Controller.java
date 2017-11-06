package Model;

public class Controller {
	
	private User user;
	
	public Controller(){
		user = new User();
	}
	
	public User getUser(){
		return user;
	} 
	
	public void setUser(User user){
		this.user = user;
	}
	
}
