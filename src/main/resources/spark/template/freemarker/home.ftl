<!DOCTYPE html>
<head>
    <title>${title}</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        table {
            margin: 0.5rem 0 0.5rem 0
        }
    </style>
</head>
<body>
    <h1>${title}</h1>
    <a href="/newCard">New Card</a>
    <#if undoUuid??>
        <h3>Card archived.</h3>
        <form method="post" action="/undoArchiveCard">
            <button type="submit" name="uuid" value="${undoUuid}">
                Undo
            </button>
        </form>
        <br/>
    </#if>

    <#-- TODO: Put undo form button here.  Remember you don't always want it there, only if you've already archived a task -->

    <div>
        <#-- TODO: Iterate through list of cards here. Each card follows the below HTML structure. -->
            <table>
                <thead>
                    <tr>
	                    <#list cards as card>
                    		<th>
                    			${card.title}
                    		</th>
	                    </#list>
                    </tr>
                </thead>
                <tbody>
               	
                    <#-- TODO: Print out all card description, status, and owner here. -->
                    <tr>
                    	<#list cards as card>
                    
                        	<td>
                        		${card.description}
                      	  </td>
                    
                  	  	</#list>
                	</tr>
                	<tr>
                    	<#list cards as card>
                    
                        	<td>
                        		${card.status}
                        	</td>
                        </#list>
                	</tr>
                    <tr>
                    	<#list cards as card>
                    
	                        <td>
	                        	${card.owner}
	                        </td>
                         </#list>
                	</tr>
                    <tr>
                    	
                    	<#list cards as card>
                        <td>
                            <form action="/editCard">
                                <button type="submit" name="uuid" value="${card.uuid}">
                                    Edit
                                </button>
                            </form>
                      	</td>
                      	</#list>
                		
                	</tr>
                    <tr>
                    
                    	<#list cards as card>
                    <td>
                        	<form method="post" action="/archiveCard">
                            	<button type="submit" name="uuid" value="${card.uuid}">
                                	Archive
                            	</button>
                        	</form>
                    </td>
                     	</#list>
                	
                	</tr>
                </tbody>
            </table>
    </div>
</body>