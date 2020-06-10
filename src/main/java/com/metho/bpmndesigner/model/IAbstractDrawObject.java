package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

/**
 * this is the abstract class for <code>DrawObject</code> and <code>Group</code>
 */
// public abstract class AbstractDrawObject {
public interface AbstractDrawObject {
	
//			abstract public AbstractDrawObject clone();
			AbstractDrawObject clone();

			int hashCode();
			
//			@Override
//			abstract public int hashCode();
/*			
			{
				final int prime = 31;
				int result = 1;
				result = prime * result + 1;
				return result;
			}
*/
			boolean equals(Object obj);
			
/*			
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				AbstractDrawObject other = (AbstractDrawObject) obj;
				return true;
			}
*/			
}
