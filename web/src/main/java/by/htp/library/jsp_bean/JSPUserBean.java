package by.htp.library.jsp_bean;

import by.htp.library.entity.User;

import java.util.List;

/**
 * Created by oxothuk1401 on 21.10.2016.
 */
public class JSPUserBean {
    private List<User> listUsers;
    private int countAllUsers;
    private int amount;
    private int position;

    public JSPUserBean(List<User> listUsers, int countAllUsers, int amount, int position) {
        this.listUsers = listUsers;
        this.countAllUsers=countAllUsers;
        this.amount = amount;
        this.position=position;
    }

    public JSPUserBean() {

    }

    public int getSize() {
        return (listUsers.size());
    }

    public User getElement(int i) {
        return listUsers.get(i);
    }


    public int getCountAllUsers() {
        return countAllUsers;
    }

    public void setCountAllUsers(int countAllUsers) {
        this.countAllUsers = countAllUsers;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "JSPUserBean{" +
                "listUsers=" + listUsers +
                ", countAllUsers=" + countAllUsers +
                ", amount=" + amount +
                ", position=" + position +
                '}';
    }
}