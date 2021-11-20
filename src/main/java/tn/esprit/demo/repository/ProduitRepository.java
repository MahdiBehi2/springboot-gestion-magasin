package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Produit;

import java.util.Date;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {

    @Query("SELECT sum(df.prixTotal) FROM detailFacture df WHERE df.produit=:produit AND df.facture.dateFacture " +
            "BETWEEN :startDate and :endDate and df.facture.active=true")
    public float getRevenuBrutProduit(@Param("produit") Long produit,
                                      @Param("startDate") Date startDate,
                                      @Param("endDate") Date endDate);
}
