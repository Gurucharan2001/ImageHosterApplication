package com.imagehoster.ImageHosterApplication.repository;

import com.imagehoster.ImageHosterApplication.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class ImageRepository {

    @PersistenceUnit(name = "imageHost")
    private EntityManagerFactory entityManagerFactory;

    public List<Image> getAllImages(Integer userId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Image> query = entityManager.createQuery("SELECT i FROM Image i JOIN FETCH i.user iuser WHERE iuser.id=:userId",Image.class);
        query.setParameter("userId",userId);
        List<Image> result = query.getResultList();
        return result;
    }

    public void hostImage(Image newImage){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(newImage);
            transaction.commit();
        }
        catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }


    public void deleteImage(Integer imageId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Image image = entityManager.find(Image.class,imageId);
            entityManager.remove(image);
            transaction.commit();
        }
        catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }
}
