/**
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.neo4j.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.data.neo4j.model.Person;

/**
 * @author Thomas Darimont
 */
public interface RedeclaringRepositoryMethodsRepository extends GraphRepository<Person> {

	/**
	 * Should not find any persons at all.
	 */
	@Query("START n=node(*) where HAS(n.name) AND n.name='Bubu' return n")
	EndResult<Person> findAll();

	/**
	 * Should only find persons with the name 'Oliver'.
	 * 
	 * @param page
	 * @return
	 */
	@Query("START n=node(*) where HAS(n.name) AND n.name='Oliver' return n")
	Page<Person> findAll(Pageable page);
}
