package com.tor.web.servletDAO;

/**
 * User: tor
 * Date: 30.08.19
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    String login;
    String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* Метод простейшей авторизации.
     * Выполняется проверка имени и пароля пользователя.
     * Результат проверки - наименование страницы перехода
     */
    public String checkLogin() {
        if (login.equalsIgnoreCase("user") && password.equalsIgnoreCase("159753")) {
         /*   Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
            principal.getName();
            Map<String,String> params =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();*/


            // Get the current servlet request from the facesContext
            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();

            // Do login from the container (will call login module)
            try {
                request.login(login, password);
                request.setAttribute(Params.EMPLOYEE_ID.toString(), 1234567);
                return "/pgs/loginsuccess?faces-redirect=true";
            } catch (ServletException ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: Login failed", null));
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        return "/pgs/loginfailed?faces-redirect=true";
    }

    //logout event, invalidate session
    public String logout() {
        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        session.invalidate();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        try {
            request.logout();
        } catch (ServletException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: LogOut failed", null));
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, e);
        }
        return "/pgs/login?faces-redirect=true";
    }
}
