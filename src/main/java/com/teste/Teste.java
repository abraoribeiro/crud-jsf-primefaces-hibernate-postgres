package com.teste;

import com.persistencia.HibernateUtil;

public class Teste {

	public static void main(String args[]) {

		HibernateUtil.getSessionFactory().openSession();

		HibernateUtil.getSessionFactory().close();
		System.out.println("sucesso");

	}

}
