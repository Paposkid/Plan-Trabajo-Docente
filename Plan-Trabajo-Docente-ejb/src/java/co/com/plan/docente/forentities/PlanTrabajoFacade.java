/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plan.docente.forentities;

import co.com.plan.docente.entities.PlanTrabajo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 727855
 */
@Stateless
public class PlanTrabajoFacade extends AbstractFacade<PlanTrabajo> implements PlanTrabajoFacadeLocal {
    @PersistenceContext(unitName = "Plan-Trabajo-Docente-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanTrabajoFacade() {
        super(PlanTrabajo.class);
    }
    
}
