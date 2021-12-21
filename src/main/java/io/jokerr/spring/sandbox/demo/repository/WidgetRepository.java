package io.jokerr.spring.sandbox.demo.repository;

import io.jokerr.spring.sandbox.demo.model.Widget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class WidgetRepository {
    private EntityManager em;

    @Autowired
    public WidgetRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    public Widget getWidget(Integer id) {
        return em.find(Widget.class, id);
    }

    public List<Widget> getWidgets() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Widget> cq = cb.createQuery(Widget.class);
        Root<Widget> rootEntry = cq.from(Widget.class);
        CriteriaQuery<Widget> all = cq.select(rootEntry);

        TypedQuery<Widget> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
}
