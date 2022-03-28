package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDao;
import it.polito.tdp.corsi.db.StudenteDAO;

public class Model {
	
	private CorsoDao corsoDao;
	private StudenteDAO studenteDao;
	
	public Model() {
		this.corsoDao = new CorsoDao();
	}
	
	public List <Corso> getCorsiByPeriodo(int periodo){
		return this.corsoDao.getCorsiByPeriodo(periodo);
	}
	
	public Map <Corso, Integer> getIscritti (int periodo) {
		return this.corsoDao.getIscritti(periodo);
	}
	
	public List<Studente> getStudentiByCorso (String codins){
		return this.studenteDao.getStudenteByCorso(codins);
	}
	
	public List<Divisione> getDivisioneStudenti (String codins){
		return this.studenteDao.getDivisioneStudenti(codins);
	}
}
