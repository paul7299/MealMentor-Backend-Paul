package dat3.openai_demo.repository;

import dat3.openai_demo.entity.Allergy;
import dat3.openai_demo.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
