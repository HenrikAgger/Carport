<%-- 
    Document   : viewdrawing
    Created on : 16-10-2018, 08:36:04
    Author     : Henrik
--%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.LineItems"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
   int kanvasLength = (request.getAttribute("kanvasLength")==null)?15:(int)request.getAttribute("kanvasLength");
   int kanvasHeight = (request.getAttribute("kanvasHeight")==null)?15:(int)request.getAttribute("kanvasHeight");
   int frontLength = (request.getAttribute("frontLength")==null)?9:(int)request.getAttribute("frontLength"); 
   int backLength = (request.getAttribute("backLength")==null)?9:(int)request.getAttribute("backLength"); 
   int sides = (request.getAttribute("sides")==null)?15:(int)request.getAttribute("sides");
   int stropeLength = 55; // = (request.getAttribute("stropes")==null)?15:(int)request.getAttribute("stropes");
   int posts = (request.getAttribute("posts")==null)?15:(int)request.getAttribute("posts");
   int stropes = (request.getAttribute("stropes")==null)?15:(int)request.getAttribute("stropes");
   int rafter = (request.getAttribute("rafter")==null)?15:(int)request.getAttribute("rafter");
   int roofLength = (request.getAttribute("roofLength")==null)?15:(int)request.getAttribute("roofLength");
   int roofHeight = (request.getAttribute("roofHeight")==null)?9:(int)request.getAttribute("roofHeight"); 
   int length = (request.getAttribute("length")==null)?15:(int)request.getAttribute("length");
   int height = (request.getAttribute("height")==null)?9:(int)request.getAttribute("height"); 
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carport</title>
    </head>
    
    <body>
        <h1>Carport</h1>
        <!-- lav SVG Kanvas der passer i størrelsen og og giver os et 
             logisk koordinat system der er 100 gange størrer -->
        <svg width="75%" 
             viewBox="0 0 <%=kanvasLength + 200%> <%=kanvasHeight + 200%>">
            <defs>
                <marker id="beginArrow" 
                    markerWidth="9" markerHeight="9" 
                    refX="0" refY="4" 
                    orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000;" />
                </marker>
                <marker id="endArrow" 
                    markerWidth="9" markerHeight="9" 
                    refX="8" refY="4" 
                    orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
                </marker>
            </defs>
            <svg x="200" y="0" width="<%=kanvasLength%>" height="<%=kanvasHeight%>" 
                viewBox="0 0 <%=kanvasLength + 100%> <%=kanvasHeight + 100%>">
                
            </svg>
            <!-- Vertical line -->
            <line x1="100"  y1="0" x2="100" y2="<%=kanvasHeight%>" 
                style="stroke:#006600;
                       marker-start: url(#beginArrow);
                       marker-end: url(#endArrow);"/>
            <text x="140" y="<%=kanvasHeight/2%>"
                  font-size="40px"
                  text-anchor="middle"
                  style="writing-mode: tb;">Height: <%=kanvasHeight%></text>
            <!-- Horizontal line -->
            <line x1="200"  y1="<%=kanvasHeight+100%>" x2="<%=kanvasLength+200%>"   y2="<%=kanvasHeight+100%>" 
                style="stroke:#006600;
                       marker-start: url(#beginArrow);
                       marker-end: url(#endArrow);"/>
            <text x="<%=kanvasLength/2+200%>" y="<%=kanvasHeight+80%>"
                  font-size="40px"
                  text-anchor="middle">Width: <%=kanvasLength%></text>
            
            



            <!-- roof -->
            <!-- Vertical line -->
            <line x1="300"  y1="50" x2="300" y2="<%=roofHeight+50%>" 
                style="stroke:#c88937;"/>


            <!-- Horizontal line -->
            <line x1="300"  y1="50" x2="<%=roofLength+300%>"   y2="50" 
                style="stroke:#c88937;"/>
         

            <!-- Vertical line -->
            <line x1="<%=roofLength+300%>"  y1="50" x2="<%=roofLength+300%>" y2="<%=roofHeight+50%>" 
                style="stroke:#c88937;"/>
  
             <!-- Horizontal line -->
            <line x1="300"  y1="<%=roofHeight+50%>" x2="<%=roofLength+300%>"   y2="<%=roofHeight+50%>" 
                style="stroke:#c88937;"/>            
            
            
            
            <!-- posts -->
            <!-- Vertical line -->
            <line x1="<%=frontLength+300%>"  y1="<%=sides+50%>" x2="<%=frontLength+300%>" y2="<%=sides+height+50%>" 
                style="stroke:#c88937;"/>


            <!-- Horizontal line -->
            <line x1="<%=frontLength+300%>"  y1="<%=sides+50%>" x2="<%=roofLength-backLength+300%>"   y2="<%=sides+50%>" 
                style="stroke:#c88937;"/>
         

            <!-- Vertical line -->
            <line x1="<%=roofLength-backLength+300%>"  y1="<%=sides+50%>" x2="<%=roofLength-backLength+300%>" y2="<%=sides+height+50%>" 
                style="stroke:#c88937;"/>
  
            <!-- Horizontal line -->
            <line x1="<%=frontLength+300%>"  y1="<%=sides+height+50%>" x2="<%=roofLength-backLength+300%>"   y2="<%=sides+height+50%>" 
                style="stroke:#c88937;"/>
            
            
                  
                    
                <%List<LineItems> lineItems = (List<LineItems>) request.getAttribute("lineItems");%>
                
                <%
                    for (int i = 0; i < posts/2; i++) {%>
                    
            <!-- place posts left side -->
            <rect x="<%=(i*((lineItems.get(i).getLength()-100-30)/2))+((-10*i)/2)+frontLength+300%>" y="<%=sides+i*0+50%>" 
                  width="10" height="10"
                  style="stroke: #c88937;
                  fill: none;
                  "/>  
            
            <!-- place posts right side -->
            <rect x="<%=(i*((lineItems.get(i).getLength()-100-30)/2))+((-10*i)/2)+frontLength+300%>" y="<%=sides+height+i*0+40%>" 
                  width="10" height="10"
                  style="stroke: #c88937;
                  fill: none;
                  "/>  
            
            
                <% }%>                
                
                <%
                    for (int i = 0; i < 2; i++) {%>                
            <!-- place rafters -->    
            <line x1="300"  y1="<%=sides+i*height+50%>" x2="<%=roofLength+300%>"   y2="<%=sides+i*height+50%>" 
                style="stroke:#c88937;"/>
            <line x1="300"  y1="<%=sides+i*height+i*50+5%>" x2="<%=roofLength+300%>"   y2="<%=sides+i*height+i*50+5%>" 
                style="stroke:#c88937;"/>
            
                <% }%>              
          
                <%
                    for (int i = 0; i < stropes; i++) {%>
            <!-- place stropes -->
            <line x1="<%=stropeLength*i+300%>"  y1="<%=50+i*0%>" 
                  x2="<%=stropeLength*i+300%>" y2="<%=roofHeight+50+i*0%>" 
                style="stroke:#c88937;"/>                    

                <% }%>
                

           <!-- view dimensions -->    

           <!-- view width -->
           <!-- Vertical line -->
           <line x1="250"  y1="<%=sides+45%>" x2="250" y2="<%=sides+height+50+5%>" 
                style="stroke:#c88937;
                       marker-start: url(#beginArrow);
                       marker-end: url(#endArrow);"/>
            <text x="240" y="<%=(sides*2+45*2+height+15)/2%>"
                  font-size="20px"
                  text-anchor="middle"
                  style="writing-mode: tb;"> <%=height+5+5%></text>
            
            <!-- Horizontal line -->
            <line x1="245"  y1="<%=sides+45%>" x2="275"   y2="<%=sides+45%>" 
                style="stroke:#c88937;"/>
            <line x1="245"  y1="<%=sides+height+50+5%>" x2="275"   y2="<%=sides+height+50+5%>" 
                style="stroke:#c88937;"/>  
            

                
            <!-- view width concerning roof -->
           <line x1="200"  y1="50" x2="200" y2="<%=roofHeight+50%>" 
                style="stroke:#c88937;
                       marker-start: url(#beginArrow);
                       marker-end: url(#endArrow);"/>
            <text x="190" y="<%=(roofHeight+50*2)/2%>"
                  font-size="20px"
                  text-anchor="middle"
                  style="writing-mode: vertical-lr;"> <%=roofHeight%></text>

            <!-- Horizontal line -->
            <line x1="195"  y1="50" x2="275"   y2="50" 
                style="stroke:#c88937;"/>
            <line x1="195"  y1="<%=roofHeight+50%>" x2="275"   y2="<%=roofHeight+50%>" 
                style="stroke:#c88937;"/>            
            
            <!-- Horizontal line -->
            <line x1="300"  y1="<%=sides+45%>" x2="<%=roofLength+300%>"   y2="<%=sides+45%>" 
                style="stroke:#c88937;"/>
            
            
            <!-- view length -->
            <!-- Horizontal line -->
            <line x1="300"  y1="<%=sides+height+50+100%>" x2="<%=roofLength+300%>"   y2="<%=sides+height+50+100%>" 
                style="stroke:#c88937;
                       marker-start: url(#beginArrow);
                       marker-end: url(#endArrow);"/>
            <text x="<%=(roofLength+300*2)/2%>" y="<%=(roofHeight+50+50)%>"
                  font-size="20px"
                  text-anchor="middle"
                  style="writing-mode: horizontal-tb;"> <%=roofLength%></text>                
            
            <line x1="300"  y1="<%=(roofHeight+50+30)%>" x2="300"   y2="<%=(roofHeight+50+60)%>" 
                style="stroke:#c88937;"/>            

            <line x1="<%=roofLength+300%>"  y1="<%=(roofHeight+50+30)%>" x2="<%=roofLength+300%>"   y2="<%=(roofHeight+50+60)%>" 
                style="stroke:#c88937;"/>                 
            
            
            
                            <%
                    for (int i = 0; i < stropes-1; i++) {%>
                                 


            <!-- rafter -->
            <!-- Horizontal line -->
            <line x1="<%=stropeLength*i+300%>"  y1="20" x2="<%=stropeLength*i+300+55%>"   y2="20" 
                style="stroke:#c88937;
                       marker-start: url(#beginArrow);
                       marker-end: url(#endArrow);"/>
            <text x="<%=(stropeLength*i*2+55+300*2)/2%>" y="15"
                  font-size="20px"
                  text-anchor="middle"
                  style="writing-mode: horizontal-tb;"> <%=stropeLength%></text>                
            
            <line x1="300"  y1="20" x2="300"   y2="40" 
                style="stroke:#c88937;"/>             
            
            <line x1="<%=stropeLength*i+stropeLength+300%>"  y1="20" x2="<%=stropeLength*i+stropeLength+300%>"   y2="40" 
                style="stroke:#c88937;"/> 
            
            
            <line x1="<%=stropeLength*(stropes-1)+300%>"  y1="20" x2="<%=roofLength+300%>"   y2="20" 
                style="stroke:#c88937;
                       marker-start: url(#beginArrow);
                       marker-end: url(#endArrow);"/>
            <text x="<%=((roofLength+300)*2-(roofLength-stropeLength*(stropes-1)))/2%>" y="15"
                  font-size="20px"
                  text-anchor="middle"
                  style="writing-mode: horizontal-tb;"> <%=(roofLength-stropeLength*(stropes-1))%></text>              
            
            <line x1="<%=roofLength+300%>"  y1="20" x2="<%=roofLength+300%>"   y2="40" 
                style="stroke:#c88937;"/>            
                           
                <% }%>            

        </svg>
    </body>
</html>
