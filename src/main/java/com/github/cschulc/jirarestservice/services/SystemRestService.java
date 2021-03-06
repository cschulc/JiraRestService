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

import com.github.cschulc.jirarestservice.domain.AttachmentMetaBean;
import com.github.cschulc.jirarestservice.domain.IssuetypeBean;
import com.github.cschulc.jirarestservice.domain.PriorityBean;
import com.github.cschulc.jirarestservice.domain.StatusBean;
import com.github.cschulc.jirarestservice.domain.avatar.AvatarBean;
import com.github.cschulc.jirarestservice.domain.avatar.AvatarType;
import com.github.cschulc.jirarestservice.domain.avatar.SystemAvatarsBean;
import com.github.cschulc.jirarestservice.domain.field.CreateFieldBean;
import com.github.cschulc.jirarestservice.domain.field.FieldBean;
import com.github.cschulc.jirarestservice.domain.system.ConfigurationBean;

import java.util.List;
import java.util.concurrent.Future;

public interface SystemRestService {

    /**
     * Return the ConfigurationBean of the remote Jira Instanz
     *
     * @return ConfigurationBean
     */
    Future<ConfigurationBean> getConfiguration();

    /**
     * Returns a list of all issue types visible to the connected client.
     *
     * @return list of issue types
     */
    Future<List<IssuetypeBean>> getIssueTypes();

    /**
     * Returns a list of all statuses.
     *
     * @return list of statuses
     */
    Future<List<StatusBean>> getStates();


    /**
     * Returns a List of all PriorityBean Object from the Remote Jira.
     *
     * @return A {@link List} of {@link PriorityBean}
     */
    Future<List<PriorityBean>> getPriorities();


    /**
     * Return a List of all FieldEnum configure in Jira, standard and custom
     *
     * @return a List of FieldEnum
     */
    Future<List<FieldBean>> getAllFields();


    /**
     * Return all Custom FieldEnum configure in the Jira
     *
     * @return a List of FieldEnum
     */
    Future<List<FieldBean>> getAllCustomFields();

    /**
     * Return a Custom FieldEnum by Id
     *
     */
    Future<FieldBean> getCustomFieldById(String id);


    /**
     * Get the AttachmentBean MetaBean Information for the jira instanz
     *
     * @return AttachmentMetaBean
     */
    Future<AttachmentMetaBean> getAttachmentMeta();

    /**
     * Creates a Custom FieldEnum
     *
     * @param fieldBean The CreateFieldBean with the create Informations
     * @return The created FieldEnum as FieldEnum
     */
    Future<FieldBean> createCustomField(CreateFieldBean fieldBean);

    /**
     * Returns all system avatars of the given type.
     *
     * @param avatarType The {@link AvatarType}
     * @return SystemAvatarsBean with a List of {@link AvatarBean}
     */
    Future<SystemAvatarsBean> getAllSystemAvatars(AvatarType avatarType);
}
