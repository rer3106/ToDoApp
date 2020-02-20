<!DOCTYPE html>
<head>
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>
<div>
    <form action="/editCard" method="post">
        <input type="hidden" name="uuid" value="${card.uuid}">
        Title:
        <input type="text" name="title" value="${card.title}">
        <br/>
        Description:
        <input type="text" name="description" value="${card.description}">
        <br/>
        Status:
        <select name="status">
            <#list statuses as status>
                <option value="${status}" <#if card.status == status>selected</#if>>${status.description}</option>
            </#list>

            <#-- Use these if you don't want to dynamically build the select. -->
<#--            <option value="TO_DO" <#if card.status == 'TO_DO'>selected</#if>>To Do</option>-->
<#--            <option value="IN_PROGRESS" <#if card.status == 'IN_PROGRESS'>selected</#if>>In Progress</option>-->
<#--            <option value="DONE" <#if card.status == 'DONE'>selected</#if>>Done</option>-->
        </select>
        <br/>
        Owner:
        <input type="text" name="owner" value="${card.owner}">
        <input type="submit" value="Submit">
    </form>
</div>
</body>