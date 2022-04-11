package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {
	
	public void promover(Funcionario funcionario, boolean metaBatida) {
		
		Cargo cargoAtual = funcionario.getCargo();
		if (Cargo.GERENTE == cargoAtual) {
			throw new ValidacaoException("O gerente não pode ser promovido.");
		}
		
		if (!metaBatida) {
			throw new ValidacaoException("A meta não foi batida.");
		}
		
		Cargo novoCargo = cargoAtual.getProximoCargo();
		funcionario.promover(novoCargo);
	}

}
