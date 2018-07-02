package com.peng.functions;

import java.util.List;
import java.util.Map;

/**
 * Created by PeChen on 18/06/2018.
 */
public interface PageData {

    String getElementSelector(String selectorName);

    Map<String, Object> loadPage(String selectorName);
}
