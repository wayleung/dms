<%@ page contentType="image/jpeg" %>
<%@ page import="java.awt.Color,java.awt.Font,java.awt.Graphics2D"%> 
<%@ page import="java.awt.image.BufferedImage,java.util.Random,javax.imageio.ImageIO"%> 
<%@ page import="javax.servlet.*,javax.servlet.http.*"%> 
<%
int width = 62, height = 22;
BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
Graphics2D g = buffImg.createGraphics();

g.setColor(Color.WHITE);
g.fillRect(0, 0, width, height);

g.setColor(Color.BLACK);
g.drawRect(0, 0, width - 1, height - 1);

g.setColor(Color.GRAY);
Random random = new Random();		//设置随机种子		
for (int i = 0; i < 40; i++) {		//设置40条干扰线
    int x1 = random.nextInt(width);
    int y1 = random.nextInt(height);
    int x2 = random.nextInt(10);
    int y2 = random.nextInt(10);			
    g.drawLine(x1, y1, x1 + x2, y1 + y2);
}

Font font = new Font("Times New Roman", Font.PLAIN, 18);
g.setFont(font);
int length = 4;						//设置默认生成4个长度的验证码
StringBuffer randomCode = new StringBuffer();        
for (int i = 0; i < length; i++) {	//取得4位数的随机字符串
    String strRand = String.valueOf(random.nextInt(10));
	int red = random.nextInt(255);
	int green = random.nextInt(255);
	int blue = random.nextInt(255);
	g.setColor(new Color(red, green, blue));            
	g.drawString(strRand, 13 * i + 6, 16);
    randomCode.append(strRand);
}

buffImg.flush();
g.dispose();


session.setAttribute("randomCode", randomCode.toString());


response.setContentType("image/jpeg");
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);

ServletOutputStream outputStream = response.getOutputStream();
ImageIO.write(buffImg, "jpeg", outputStream);
outputStream.close();

out.clear();   
out = pageContext.pushBody();  
/*
这两句代码是用于解决问题：java.lang.IllegalStateException: getOutputStream() has already been called 
由于jsp container在处理完成请求后会调用releasePageContet方法释放所用的PageContext object,
并且同时调用getWriter方法,由于getWriter方法与在jsp页面中使用流相关的getOutputStream方法冲突,
所以会造成这种异常
*/
%>