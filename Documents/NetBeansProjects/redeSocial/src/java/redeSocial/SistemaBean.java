/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrik
 */
@ManagedBean
@ApplicationScoped

public class SistemaBean {
	private List<String> mensagens;
	private List<String> autor;
	private List<PessoaBean> cadastro;
	//private List<List<String>> amigoAdicionado;
	//private List<String> amigo;
	private int pessoaID;
	
	public SistemaBean(){
		mensagens= new ArrayList<String>();
		mensagens.add("exemplo");
		autor=new ArrayList<String>();
		autor.add("sistema");
		cadastro=new ArrayList<PessoaBean>();
		pessoaID=-1;
		//amigo=new ArrayList<String>();
		//amigoAdicionado=new ArrayList<List<String>>();
	}

	public String getNome(){
		return cadastro.get(pessoaID).getNome();
	}
	
	public void addPessoa(PessoaBean p,String erroSenha,String erroCadastro) {
		boolean cadastrou=false;
		ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
		HttpServletResponse response=(HttpServletResponse)context.getResponse();
		for(int i=cadastro.size()-1; i>=0;i--){
			if(p.getEmail().equals(cadastro.get(i).getEmail())){
				cadastrou=true;
				cadastro.get(i).sair();
				response.setContentType("text/html");
				PrintWriter out=null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					out.println("<p id=\"centro\" class=\"error\">"+erroCadastro+"</p>");
			}
		}
		if(!cadastrou)
		if(p.verificarSenha(erroSenha)){
			pessoaID=cadastro.size();
			cadastro.add(p);
			try {
				response.sendRedirect("Conteudo.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean verificarEmail(PessoaBean p,String erroEmail){
		boolean achou=false;
		for(int i=cadastro.size()-1;!achou&&i>0;i--)
			if(p.getEmail().equals(cadastro.get(i).getEmail())){
				achou=true;
				pessoaID=i;
			}
		if(!achou){
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
				out.println("<p id=\"centro\" class=\"error\">"+erroEmail+"</p>");
		}
		return achou;
	}
	
	public void verificarSenha(PessoaBean p,String erroEmail,String erroSenha){
		if(verificarEmail(p,erroEmail)){
			ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
			HttpServletResponse response=(HttpServletResponse)context.getResponse();
			if(p.getSenha().equals(cadastro.get(pessoaID).getSenha())){				
				try {
					response.sendRedirect("Conteudo.xhtml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				cadastro.get(pessoaID).sair();
				response.setContentType("text/html");
				PrintWriter out=null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.println("<p id=\"centro\" class=\"error\">"+erroSenha+"</p>");
			}
		}
	}
	
	public void addMensagem(PessoaBean p) {
		mensagens.add(p.getMensagem());
		autor.add(p.getNome());
	}
	
	public void mostrarMensagens(String texto){
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
		for(int i=mensagens.size()-1; i>0;i--){
			//out.println("<p class=\"amigo\"><br />");
			out.println("<p>");
			String mensagem=mensagens.get(i);
			for(int j=0;j<mensagem.length();j++){
				out.print(mensagem.charAt(j));
				if(j%21==20)
					out.println("<br />");
			}
			out.println("<br />"+texto+" "+autor.get(i)+"<br /></p>");
		}
	}
	
	public void mostrarPessoasCadastrados(String texto){
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
		for(int i=cadastro.size()-1; i>=0;i--){
			if(pessoaID!=i){
				PessoaBean pessoa=cadastro.get(i);
				out.println("<br />"+pessoa.getNome());
			}
		}
		
	}
	
	public void adicionarAmigo(){
		
	}
	
}
