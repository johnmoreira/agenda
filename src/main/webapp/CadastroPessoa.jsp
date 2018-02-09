<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pessoas</title>
<script>
	var cod = 0;
$(document).ready(function(){
	$("#listaTelefones").on("click",".remove", function(e){
		e.preventDefault();
		var row=$(this).closest("tr");
		row.remove();
	});
	});
	
	$(function(){
		$(".add").click(function(){
		var ddd = $("#telefoneDdd").val();
		var num = $("#telefoneNumero").val();
		var deleta = "<input type='button' value='deletar' class='remove'/>";
		cod = cod+1;
        $("tbody").append("<tr><td id='lCod'>"+cod+"</td><td id='lDdd'>"+ddd+"</td><td id='lNum'>"+num+"</td><td>"+deleta+"</td></tr>");
			
    });
});
</script>
</head>
<body>

	<h2>Cadastro de Pessoas</h2>
		<form method="post" action="AgendaServlet?acao=registar">
		<div align="center" id="pessoaDIV" class="header">
		<fieldset>
			<p><label>Nome:</label><input type="text" id="pessoaNome" placeholder="João"/>
			<label>CPF:</label><input type="text" id="pessoaCpf" placeholder="00000000000"/> </p>
			<label>Email:</label><input type="text" id="pessoaEmail" placeholder="João@email.com"/>
			<label>Data de Nascimento:</label><input type="text" id="pessoaNascimento" placeholder="xx-xx-xxxx"/>
		</fieldset>
		<fieldset>
			<label>DDD</label> <label>Telefone</label>
			<input type="text" id="telefoneDdd"/> <input type="text" id="telefoneNumero"/> <button type="button" class="add">adicionar</button>
			<table border="1" id="listaTelefones">
			<thead>
			<tr>
				<th>Cod</th>
				<th>Ddd</th>
				<th>Telefone</th>
				<th>Acões</th>
			</tr>
			</thead>
			<tbody>
			</tbody>
			</table>
			<input type="submit" value="Cadastrar"/>
			</fieldset>
		</div>
		</form>
		
				<a href = "index.jsp">voltar</a>
	
</body>
</html>