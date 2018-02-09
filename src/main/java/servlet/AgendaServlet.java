package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDAO;
import dao.TelefoneDAO;
import entidades.Pessoa;
import entidades.Telefone;

@WebServlet(name="Agenda Servlet", urlPatterns="/AgendaServlet")
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Pessoa pessoa = new Pessoa();
	Telefone telefone = new Telefone();
	List <Telefone> listaTelefone = new ArrayList<Telefone>();
	PessoaDAO pDAO = new PessoaDAO();
	TelefoneDAO tDAO = new TelefoneDAO();
	String mensagem = null;
	
    public AgendaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "salvar": salvar(request, response);
		break;
		case "consultar": consultar(request, response);
		break;
		case "atualizar": atualizar(request, response);
		break;
		case "deletar": deletar(request, response);
		break;
		} 
	}

	
	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			pessoa.setNome(request.getParameter("pessoaNome"));
			pessoa.setCpf(request.getParameter("pessoaCpf"));
			pessoa.setEmail(request.getParameter("pessoaEmail"));
			
			String cod[] = request.getParameterValues("lCod");
			String ddd[] = request.getParameterValues("lDdd");
			String num[] = request.getParameterValues("lNum");
			
			for(String a : cod) {
				int c = 1;
				telefone.setId((long) c);
				telefone.setDdd(ddd[c]);
				telefone.setNumero(num[c]);
				c++;
				tDAO.salvar(telefone);
				listaTelefone.add(telefone);
				System.out.println(listaTelefone);
			}
			
			pessoa.setTelefone(listaTelefone);
			
			try {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");					
				pessoa.setDataNascimento(df.parse(request.getParameter("pessoaData")));
			} catch (Exception e) {
				//pessoa.setData(new Date());	
			}
			
			pDAO.salvar(pessoa);
			//tDAO.salvar(telefone);
			} catch (Exception e) {
				mensagem += e.getMessage();
			}
			
			if(mensagem != null) {
				mensagem = "Ocorreu um erro, por favor tente novamente.";
			}else {
				mensagem = "Operação realizada com sucesso!";
			}
				
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher rd = request.getRequestDispatcher("resultado.jsp");
			rd.forward(request, response);  
		}

	private void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	
	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	
	private void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
