/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.enem.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fabricio
 */
public class JpaUtil {
 
    @PersistenceContext(unitName = "br.com.ifc.enem_Enem-ejb_ejb_1.0PU")
    protected EntityManager em;
}
