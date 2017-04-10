package com.persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Departamento;


public class DepartamentoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static void inserir(Departamento d) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(d);
		t.commit();
		sessao.close();
	}

	public static void alterar(Departamento d) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(d);
		t.commit();
		sessao.close();
	}

	public static void excluir(Departamento d) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(d);
		t.commit();
		sessao.close();
	}

	public static List<Departamento> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Departamento order by id");
		} else {
			consulta = sessao.createQuery("from Departamento " + "where nome like :parametro order by id");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List<Departamento> lista = consulta.list();
		sessao.close();
		return lista;
	}

}
