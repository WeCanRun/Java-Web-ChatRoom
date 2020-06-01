package com.vo;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    private Integer id;
    private String username;
    private String password;
    private String repassword;
    private String phone;
    private String adress;
    private Integer type;
    private boolean flag = false;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", type=" + type +
                ", flag=" + flag +
                '}';
    }

    @SuppressWarnings("unchecked")
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("已登录....");
        HttpSession session = event.getSession();

        Map<User, HttpSession> userMap = (Map<User, HttpSession>) session
                .getServletContext().getAttribute("userMap");

        userMap.put(this, session);

    }

    // 当session和对象解除绑定的时候
    @SuppressWarnings("unchecked")
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("已退出....");
        HttpSession session = event.getSession();
        // 获得人员列表
        Map<User, HttpSession> userMap = (Map<User, HttpSession>) session
                .getServletContext().getAttribute("userMap");
        // 将用户移除了
        userMap.remove(this);
    }

}
