package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodicidadeReajuste implements ValidacaoReajuste {

	public void validar(Funcionario funcionario, BigDecimal aumento) {

		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataHoje = LocalDate.now();
		long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataHoje);

		if (mesesDesdeUltimoReajuste < 6) {
			throw new ValidacaoException("Reajuste deve ter uma periodicidade superior ou igual a 6 meses!");
		}
	}

}
