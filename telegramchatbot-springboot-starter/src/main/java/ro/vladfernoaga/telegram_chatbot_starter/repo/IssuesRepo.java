
package ro.vladfernoaga.telegram_chatbot_starter.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.vladfernoaga.telegram_chatbot_starter.model.IssuesInfo;

public interface IssuesRepo extends JpaRepository<IssuesInfo, Long>{

	Optional<IssuesInfo> findById(Long id);
	
	Optional<IssuesInfo> findByName(String name);
 
}
