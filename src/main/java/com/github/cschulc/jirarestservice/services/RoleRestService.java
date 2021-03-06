/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.project.ProjectRoleBean;

import java.util.List;
import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 05.07.2018
 * Time: 17:22
 */
public interface RoleRestService {

    /**
     * Get all the ProjectRoles available in Jira. Currently this list is global.
     *
     * @return Future with List of {@link ProjectRoleBean}
     */
    Future<List<ProjectRoleBean>> getAllProjectRoles();

    /**
     * Creates a new ProjectRoleBean to be available in Jira. The created role does not have any default actors assigned.
     *
     * @param name The Name of the Role
     * @param description The Description of the Role
     * @return Future with {@link ProjectRoleBean}
     */
    Future<ProjectRoleBean> createProjectRole(String name, String description);

    /**
     * Get a specific ProjectRoleBean available in Jira.
     *
     * @param id The id of the Role
     * @return Future with {@link ProjectRoleBean}
     */
    Future<ProjectRoleBean> getProjectRoleById(int id);


}
