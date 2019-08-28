/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocial;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrik
 */
@ManagedBean 
@SessionScoped
public class PessoaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String email;
	private String senha;
	private String confirmarSenha;
	private String mensagem;
	
	
	public PessoaBean(){
		nome="";
		email="";
		senha="";
		confirmarSenha="";
		mensagem="";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public boolean verificarSenha(String texto){
		boolean retorno=true;
		if(!senha.equals(confirmarSenha)){
			retorno=false;
			ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
			HttpServletResponse response=(HttpServletResponse)context.getResponse();
			response.setContentType("text/html");
			PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				out.println("<p id=\"centro\" class=\"error\">"+texto+"</p>");
		}
		return retorno;
	}

	public void sair(){
		ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
		//HttpServletRequest request=(HttpServletRequest)context.getRequest();
		HttpServletResponse response=(HttpServletResponse)context.getResponse();
		HttpSession session=(HttpSession) context.getSession(false);
		session.invalidate();
		try {
			response.sendRedirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
