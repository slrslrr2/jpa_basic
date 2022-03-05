package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ParentApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Parent parent = new Parent();

            Child child = new Child();
            Child child2 = new Child();

            child.setParent(parent);
            child2.setParent(parent);

            parent.getChilds().add(child);
            parent.getChilds().add(child2);

            em.persist(parent);

            // delete query 3번 나감
            // 부모 delete
            // 부모와 연관된 자식 delete 2번
//            em.remove(parent);

            // delete 쿼리가 나가지 않는다
            // 영속성 전이 삭제 옵션은
            // 부모와 자식의 관계가 끊어졌다고 해서 자식을 삭제하지 않는다.
//            parent.getChilds().remove(0);
            em.remove(child);
            em.flush();
//            em.remove(parent);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
