/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2011, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.metamodel.spi.source;

import org.hibernate.cfg.NamingStrategy;
import org.hibernate.metamodel.spi.MetadataBuildingOptions;
import org.hibernate.metamodel.spi.MetadataImplementor;
import org.hibernate.metamodel.spi.domain.JavaClassReference;
import org.hibernate.metamodel.spi.domain.Type;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Steve Ebersole
 */
public interface BindingContext {
	public ServiceRegistry getServiceRegistry();

	public NamingStrategy getNamingStrategy();

	public MappingDefaults getMappingDefaults();

	public MetadataBuildingOptions getBuildingOptions();

	public MetadataImplementor getMetadataImplementor();

	public <T> Class<T> locateClassByName(String name);

	public Type makeDomainType(String className);

	public boolean isGloballyQuotedIdentifiers();

	public JavaClassReference makeJavaClassReference(String className);

	public JavaClassReference makeJavaClassReference(Class<?> clazz);

	public JavaClassReference makeJavaPropertyClassReference(
			JavaClassReference propertyContainerClassReference,
			String propertyName
	);

	public String qualifyClassName(String name);
}
