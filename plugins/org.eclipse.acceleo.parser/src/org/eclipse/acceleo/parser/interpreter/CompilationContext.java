/*****************************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *****************************************************************************************/
package org.eclipse.acceleo.parser.interpreter;

import com.google.common.collect.Multimap;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * This represents the context of a compilation as required by Acceleo.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class CompilationContext {
	/** The actual expression as written by the user that we are trying to compile. */
	private final String expression;

	/** This represents the type of the target EObject for which we are compiling. */
	private final String targetType;

	/**
	 * The map of variables that are to be taken into account while compiling this expression. Keys represent
	 * the variable names while values represent the variable's type.
	 */
	private final Map<String, String> variables;

	/**
	 * If we need additional dependencies to compile this expression, this should hold them. Keys represent
	 * the OCL qualified name of the dependency, values hold all potential URIs of the dependency (one
	 * qualified name may link to multiple resources.
	 */
	private final Multimap<String, URI> dependencies;

	/** The set of all metamodel URIs visible to the compiled expression. */
	private final Set<String> nsURIs;

	/**
	 * Instantiates a compilation context.
	 * 
	 * @param expression
	 *            The actual expression we are trying to compile.
	 * @param targetType
	 *            The type of the target EObject for this compilation.
	 * @param variables
	 *            The map of variables that are to be taken into account to compile this expression. May be
	 *            <code>null</code>.
	 * @param dependencies
	 *            Optional dependencies of this compilation.
	 * @param nsURIs
	 *            The set of all metamodel URIs visible to the compiled expression.
	 */
	public CompilationContext(String expression, String targetType, Map<String, String> variables,
			Multimap<String, URI> dependencies, Set<String> nsURIs) {
		this.expression = expression;
		this.targetType = targetType;
		this.variables = variables;
		this.dependencies = dependencies;
		this.nsURIs = nsURIs;
	}

	/**
	 * Returns the actual expression to compile.
	 * 
	 * @return The actual expression to compile.
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Returns the target type of this compilation.
	 * 
	 * @return The target type of this compilation.
	 */
	public String getTargetType() {
		return targetType;
	}

	/**
	 * Returns the map of accessible variables.
	 * 
	 * @return The map of accessible variables.
	 */
	public Map<String, String> getVariables() {
		return variables;
	}

	/**
	 * Returns the optional dependencies of this build.
	 * 
	 * @return The optional dependencies of this build.
	 */
	public Multimap<String, URI> getDependencies() {
		return dependencies;
	}

	/**
	 * Returns the set of all metamodel URIs visible to the compiled expression.
	 * 
	 * @return The set of all metamodel URIs visible to the compiled expression.
	 */
	public Set<String> getNsURIs() {
		return nsURIs;
	}
}