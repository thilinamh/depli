package com.depli.repositories.persistent;

import com.depli.entities.persistent.JMXNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lahiru Pathirage
 * @since 3/22/17
 */
@Repository
public interface JMXNodeRepository extends JpaRepository<JMXNode, Long> {

    public JMXNode findByHostname(String hostname);

    public JMXNode save(JMXNode jmxNode);
}
