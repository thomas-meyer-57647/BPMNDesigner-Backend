package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;

import com.metho.bpmndesigner.exception.ResourceNotFoundException;
import com.metho.bpmndesigner.model.Color;
import com.metho.bpmndesigner.model.ColorStop;
import com.metho.bpmndesigner.model.ColorStyle;
import com.metho.bpmndesigner.model.DocumentEntity;
import com.metho.bpmndesigner.model.DrawObject;
import com.metho.bpmndesigner.model.DrawObjectStyle;
import com.metho.bpmndesigner.model.EDrawType;
import com.metho.bpmndesigner.model.EGradientType;
import com.metho.bpmndesigner.model.ELineCap;
import com.metho.bpmndesigner.model.EStyleType;
import com.metho.bpmndesigner.model.GradientStyle;
import com.metho.bpmndesigner.model.IStyle;
import com.metho.bpmndesigner.model.Layer;
import com.metho.bpmndesigner.model.LineDash;
import com.metho.bpmndesigner.model.Page;
import com.metho.bpmndesigner.model.Point;
import com.metho.bpmndesigner.model.TextDecoration;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * test function for the gradient service
 */
@SpringBootTest
class DocumentServiceTest {
}
