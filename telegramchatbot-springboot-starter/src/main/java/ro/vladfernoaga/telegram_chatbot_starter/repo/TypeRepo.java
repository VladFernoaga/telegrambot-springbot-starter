package ro.vladfernoaga.telegram_chatbot_starter.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.vladfernoaga.telegram_chatbot_starter.model.TypeInfo;;

public interface TypeRepo extends JpaRepository<TypeInfo, Long> {

	Optional<TypeInfo> findById(Long id);

	Optional<TypeInfo> findByNameType(String name_type);

}
