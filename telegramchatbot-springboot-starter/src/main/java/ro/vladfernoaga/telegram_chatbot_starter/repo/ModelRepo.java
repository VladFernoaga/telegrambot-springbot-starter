package ro.vladfernoaga.telegram_chatbot_starter.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.vladfernoaga.telegram_chatbot_starter.model.ModelInfo;

public interface ModelRepo  extends JpaRepository<ModelInfo, Long>{

	Optional<ModelInfo> findById(Long id);
	
	Optional<ModelInfo>	findByName(String name);

}
