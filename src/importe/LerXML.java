package importe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LerXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File xmlFile = new File(
				"C:\\Users\\suportemaxxi\\Documents\\CTe13240423022148000122570010000110671133160818.xml");
		NotaFiscal notaFiscal = new NotaFiscal();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBulider = dbFactory.newDocumentBuilder();
		Document doc = dBulider.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		System.out.println("Nota fiscal " + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("cteProc");

		for (int percorre = 0; percorre < nList.getLength(); percorre++) {
			Node nNode = nList.item(percorre);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("---------");
				notaFiscal.setcUF(getValueIfPresent(eElement, "cUF")) ;
				notaFiscal.setcCT(getValueIfPresent(eElement, "cCT"));
				notaFiscal.setCFOP(getValueIfPresent(eElement, "CFOP"));
				notaFiscal.setNatOp(getValueIfPresent(eElement, "natOp"));
				notaFiscal.setMod(getValueIfPresent(eElement, "mod"));
				notaFiscal.setSerie(getValueIfPresent(eElement, "serie"));
				notaFiscal.setnCT(getValueIfPresent(eElement, "nCT"));
				notaFiscal.setDhEmi(getValueIfPresent(eElement, "dhEmi"));
				notaFiscal.setTpImp(getValueIfPresent(eElement, "tpImp"));
				notaFiscal.setTpEmis(getValueIfPresent(eElement, "tpEmis"));
				notaFiscal.setcDV(getValueIfPresent(eElement, "cDV"));
				notaFiscal.setTpAmb(getValueIfPresent(eElement, "tpAmb"));
				notaFiscal.setTpCTe(getValueIfPresent(eElement, "tpCTe"));
				notaFiscal.setProcEmi(getValueIfPresent(eElement, "procEmi"));
				notaFiscal.setVerProc(getValueIfPresent(eElement, "verProc"));
				notaFiscal.setcMunEnv(getValueIfPresent(eElement, "cMunEnv"));
				notaFiscal.setxMunEnv(getValueIfPresent(eElement, "xMunEnv"));
				notaFiscal.setUFEnv(getValueIfPresent(eElement, "UFEnv"));
				notaFiscal.setModal(getValueIfPresent(eElement, "modal"));
				notaFiscal.setTpServ(getValueIfPresent(eElement, "tpServ"));
				notaFiscal.setcMunIni(getValueIfPresent(eElement, "cMunIni"));
				notaFiscal.setxMunIni(getValueIfPresent(eElement, "xMunIni"));
				notaFiscal.setUFIni(getValueIfPresent(eElement, "UFIni"));
				notaFiscal.setcMunFim(getValueIfPresent(eElement, "cMunFim"));
				notaFiscal.setxMunFim(getValueIfPresent(eElement, "xMunFim"));
				notaFiscal.setUFFim(getValueIfPresent(eElement, "UFFim"));
				notaFiscal.setRetira(getValueIfPresent(eElement, "retira"));
				notaFiscal.setIndIEToma(getValueIfPresent(eElement, "indIEToma"));
				notaFiscal.setToma(getValueIfPresent(eElement, "toma"));
				notaFiscal.setTpPer(getValueIfPresent(eElement, "tpPer"));
				notaFiscal.setTpHor(getValueIfPresent(eElement, "tpHor"));
				notaFiscal.setxObs(getValueIfPresent(eElement, "xObs"));
				
				
				
				System.out.println("Emissor");
				NodeList emissor = eElement.getElementsByTagName("emit");
				for (int i = 0; i < emissor.getLength(); i++) {
					Node dependenteNode = emissor.item(i);
					if (dependenteNode.getNodeType() == Node.ELEMENT_NODE) {
						Element dependenteElement = (Element) dependenteNode;
						System.out.println("-----");
						notaFiscal.setCNPJEmi(getValueIfPresent(dependenteElement, "CNPJ"));
						notaFiscal.setIE(getValueIfPresent(dependenteElement, "IE"));
						notaFiscal.setIEST(getValueIfPresent(dependenteElement, "IEST"));
						notaFiscal.setxNomeEmi(getValueIfPresent(dependenteElement, "xNome"));
						notaFiscal.setxFantEmi(getValueIfPresent(dependenteElement, "xFant"));
						notaFiscal.setxLgrEmi(getValueIfPresent(dependenteElement, "xLgr"));
						notaFiscal.setNroEmi(getValueIfPresent(dependenteElement, "nro"));
						notaFiscal.setxBairroEmi(getValueIfPresent(dependenteElement, "xBairro"));
						notaFiscal.setcMunEmi(getValueIfPresent(dependenteElement, "cMun"));
						notaFiscal.setxMunEmi(getValueIfPresent(dependenteElement, "xMun"));
						notaFiscal.setCEPEmi(getValueIfPresent(dependenteElement, "CEP"));
						notaFiscal.setUFEmi(getValueIfPresent(dependenteElement, "UF"));
						notaFiscal.setFoneEmi(getValueIfPresent(dependenteElement, "fone"));
						notaFiscal.setCRT(getValueIfPresent(dependenteElement, "CRT"));
					}
				}
				
				System.out.println("---------------------------------------------------------");
				System.out.println("Rementente");
				NodeList remetente = eElement.getElementsByTagName("rem");
				for (int i = 0; i < remetente.getLength(); i++) {
					Node dependenteNode = remetente.item(i);
					if (dependenteNode.getNodeType() == Node.ELEMENT_NODE) {
						Element dependenteElement = (Element) dependenteNode;
						System.out.println("-----");
						notaFiscal.setCNPJRem(getValueIfPresent(dependenteElement, "CNPJ"));
						notaFiscal.setIERem(getValueIfPresent(dependenteElement, "IE"));
						notaFiscal.setxNomeRem(getValueIfPresent(dependenteElement, "xNome"));
						notaFiscal.setxFantRem(getValueIfPresent(dependenteElement, "xFant"));
						notaFiscal.setxLgrRem(getValueIfPresent(dependenteElement, "xLgr"));
						notaFiscal.setNroRem(getValueIfPresent(dependenteElement, "nro"));
						notaFiscal.setxBairroRem(getValueIfPresent(dependenteElement, "xBairro"));
						notaFiscal.setcMunRem(getValueIfPresent(dependenteElement, "cMun"));
						notaFiscal.setxMunRem(getValueIfPresent(dependenteElement, "xMun"));
						notaFiscal.setCEPRem(getValueIfPresent(dependenteElement, "CEP"));
						notaFiscal.setUFRem(getValueIfPresent(dependenteElement, "UF"));
						notaFiscal.setcPaisRem(getValueIfPresent(dependenteElement, "cPais"));
						notaFiscal.setxPaisRem(getValueIfPresent(dependenteElement, "xPais"));
					}
				}
				
				System.out.println("---------------------------------------------------------");
				System.out.println("Expedidor");
				NodeList expedidor = eElement.getElementsByTagName("exped");
				for (int i = 0; i < expedidor.getLength(); i++) {
					Node dependenteNode = expedidor.item(i);
					if (dependenteNode.getNodeType() == Node.ELEMENT_NODE) {
						Element dependenteElement = (Element) dependenteNode;
						System.out.println("-----");
						notaFiscal.setCNPJExped(getValueIfPresent(dependenteElement, "CNPJ"));
						notaFiscal.setIEExped(getValueIfPresent(dependenteElement, "IE"));
						notaFiscal.setxNomeExped(getValueIfPresent(dependenteElement, "xNome"));
						notaFiscal.setxLgrExped(getValueIfPresent(dependenteElement, "xLgr"));
						notaFiscal.setNroExped(getValueIfPresent(dependenteElement, "nro"));
						notaFiscal.setxBairroExped(getValueIfPresent(dependenteElement, "xBairro"));
						notaFiscal.setcMunExped(getValueIfPresent(dependenteElement, "cMun"));
						notaFiscal.setxMunExped(getValueIfPresent(dependenteElement, "xMun"));
						notaFiscal.setCEPExped(getValueIfPresent(dependenteElement, "CEP"));
						notaFiscal.setUFExped(getValueIfPresent(dependenteElement, "UF"));
						notaFiscal.setcPaisExped(getValueIfPresent(dependenteElement, "cPais"));
						notaFiscal.setxPaisExped(getValueIfPresent(dependenteElement, "xPais"));
					}
				}
				
				System.out.println("---------------------------------------------------------");
				System.out.println("Recebedor");
				NodeList recebedor = eElement.getElementsByTagName("receb");
				for (int i = 0; i < recebedor.getLength(); i++) {
					Node dependenteNode = recebedor.item(i);
					if (dependenteNode.getNodeType() == Node.ELEMENT_NODE) {
						Element dependenteElement = (Element) dependenteNode;
						System.out.println("-----");
						notaFiscal.setCNPJReceb(getValueIfPresent(dependenteElement, "CNPJ"));
						notaFiscal.setIEReceb(getValueIfPresent(dependenteElement, "IE"));
						notaFiscal.setxNomeReceb(getValueIfPresent(dependenteElement, "xNome"));
						notaFiscal.setxLgrReceb(getValueIfPresent(dependenteElement, "xLgr"));
						notaFiscal.setNroReceb(getValueIfPresent(dependenteElement, "nro"));
						notaFiscal.setxBairroReceb(getValueIfPresent(dependenteElement, "xBairro"));
						notaFiscal.setcMunReceb(getValueIfPresent(dependenteElement, "cMun"));
						notaFiscal.setxMunReceb(getValueIfPresent(dependenteElement, "xMun"));
						notaFiscal.setCEPReceb(getValueIfPresent(dependenteElement, "CEP"));
						notaFiscal.setUFReceb(getValueIfPresent(dependenteElement, "UF"));
						notaFiscal.setcPaisReceb(getValueIfPresent(dependenteElement, "cPais"));
						notaFiscal.setxPaisReceb(getValueIfPresent(dependenteElement, "xPais"));
					}
				}
				
				System.out.println("---------------------------------------------------------");
				System.out.println("Destinatário");
				NodeList destinatario = eElement.getElementsByTagName("receb");
				for (int i = 0; i < destinatario.getLength(); i++) {
					Node dependenteNode = destinatario.item(i);
					if (dependenteNode.getNodeType() == Node.ELEMENT_NODE) {
						Element dependenteElement = (Element) dependenteNode;
						System.out.println("-----");
						notaFiscal.setCNPJDest(getValueIfPresent(dependenteElement, "CNPJ"));
						notaFiscal.setIEDest(getValueIfPresent(dependenteElement, "IE"));
						notaFiscal.setxNomeDest(getValueIfPresent(dependenteElement, "xNome"));
						notaFiscal.setxLgrDest(getValueIfPresent(dependenteElement, "xLgr"));
						notaFiscal.setNroDest(getValueIfPresent(dependenteElement, "nro"));
						notaFiscal.setxBairroDest(getValueIfPresent(dependenteElement, "xBairro"));
						notaFiscal.setcMunDest(getValueIfPresent(dependenteElement, "cMun"));
						notaFiscal.setxMunDest(getValueIfPresent(dependenteElement, "xMun"));
						notaFiscal.setCEPDest(getValueIfPresent(dependenteElement, "CEP"));
						notaFiscal.setUFDest(getValueIfPresent(dependenteElement, "UF"));
						notaFiscal.setcPaisDest(getValueIfPresent(dependenteElement, "cPais"));
						notaFiscal.setxPaisDest(getValueIfPresent(dependenteElement, "xPais"));
					}
				}
				
				System.out.println("---------------------------------------------------------");
				notaFiscal.setvTPrest(getValueIfPresent(eElement, "vTPrest"));
				notaFiscal.setvRec(getValueIfPresent(eElement, "vRec"));
				notaFiscal.setCST(getValueIfPresent(eElement, "CST"));
				notaFiscal.setvBCSTRet(getValueIfPresent(eElement, "vBCSTRet"));
				notaFiscal.setvICMSSTRet(getValueIfPresent(eElement, "vICMSSTRet"));
				notaFiscal.setpICMSSTRet(getValueIfPresent(eElement, "pICMSSTRet"));
				notaFiscal.setvCred(getValueIfPresent(eElement, "vCred"));
				notaFiscal.setvCarga(getValueIfPresent(eElement, "vCarga"));
				notaFiscal.setProPred(getValueIfPresent(eElement, "proPred"));
				notaFiscal.setcUnid(getValueIfPresent(eElement, "cUnid"));
				notaFiscal.setTpMed(getValueIfPresent(eElement, "tpMed"));
				notaFiscal.setqCarga(getValueIfPresent(eElement, "qCarga"));
				
				System.out.println("---------------------------------------------------------");
				System.out.println("Informações Documento");
				NodeList infDoc = eElement.getElementsByTagName("infNFe");
				for (int i = 0; i < infDoc.getLength(); i++) {
					Node dependenteNode = infDoc.item(i);
					if (dependenteNode.getNodeType() == Node.ELEMENT_NODE) {
						Element dependenteElement = (Element) dependenteNode;
						notaFiscal.setChave(dependenteElement.getElementsByTagName("chave").item(0).getTextContent());
					}
				}
				
				System.out.println("---------------------------------------------------------");
				System.out.println("Tipo do Modal");
				NodeList aquav = eElement.getElementsByTagName("aquav");
				for (int i = 0; i < aquav.getLength(); i++) {
					Node dependenteNode = aquav.item(i);
					if (dependenteNode.getNodeType() == Node.ELEMENT_NODE) {
						Element dependenteElement = (Element) dependenteNode;
						System.out.println("-----");
						notaFiscal.setvPrest(getValueIfPresent(dependenteElement, "vPrest"));
						notaFiscal.setvAFRMM(getValueIfPresent(dependenteElement, "vAFRMM"));
						notaFiscal.setxNavio(getValueIfPresent(dependenteElement, "xNavio"));
						notaFiscal.setxBalsa(getValueIfPresent(dependenteElement, "xBalsa"));
						notaFiscal.setDirec(getValueIfPresent(dependenteElement, "direc"));
						notaFiscal.setIrin(getValueIfPresent(dependenteElement, "irin"));

					}
				}
				
				System.out.println("---------------------------------------------------------");
				System.out.println("Informações Responsável Técnico");
				NodeList infRespTec = eElement.getElementsByTagName("infRespTec");
				for (int i = 0; i < infRespTec.getLength(); i++) {
					Node dependenteNode = infRespTec.item(i);
					if (dependenteNode.getNodeType() == Node.ELEMENT_NODE) {
						Element dependenteElement = (Element) dependenteNode;
						System.out.println("-----");
						notaFiscal.setCNPJRespTec(getValueIfPresent(dependenteElement, "CNPJ"));
						notaFiscal.setxContato(getValueIfPresent(dependenteElement, "xContato"));
						notaFiscal.setEmail(getValueIfPresent(dependenteElement, "email"));
						notaFiscal.setFone(getValueIfPresent(dependenteElement, "fone"));
					}
				}
				notaFiscal.setQrCodCTe(getValueIfPresent(eElement, "qrCodCTe"));
				notaFiscal.setDigVal(getValueIfPresent(eElement, "DigestValue"));
				notaFiscal.setX509Certificate(getValueIfPresent(eElement, "X509Certificate"));
																
				System.out.println("---------------------------------------------------------");
				System.out.println("ultimo");
				NodeList protCTe = eElement.getElementsByTagName("infProt");
				for (int i = 0; i < protCTe.getLength(); i++) {
					Node dependenteNode = protCTe.item(i);
					if (dependenteNode.getNodeType() == Node.ELEMENT_NODE) {
						Element dependenteElement = (Element) dependenteNode;
						System.out.println("-----");
						notaFiscal.setVerAplic(getValueIfPresent(dependenteElement, "verAplic"));
						notaFiscal.setChCTe(getValueIfPresent(dependenteElement, "chCTe"));
						notaFiscal.setDhRecbto(getValueIfPresent(dependenteElement, "dhRecbto"));
						notaFiscal.setnProt(getValueIfPresent(dependenteElement, "nProt"));
						notaFiscal.setDigVal(getValueIfPresent(dependenteElement, "digVal"));
						notaFiscal.setcStat(getValueIfPresent(dependenteElement, "cStat"));
						notaFiscal.setxMotivo(getValueIfPresent(dependenteElement, "xMotivo"));
					}
				}
					
			}
		}
		
			try{

			String msgRetorno = "";

			// Definir a URL Do Serviço sem a ?WSDL no fim
			URL url = new URL("http://SUPORTEMAXXI40:8080/g5-senior-services/sapiens_Synccom_senior_g5_co_mcm_ven_conhecimentotransporte");
			URLConnection conn = url.openConnection();

            // Define que a Conexão terá uma saída/retorno						
			conn.setDoOutput(true);

			// Método a ser Consumido pela requisição
			conn.setRequestProperty("SOAPAction","http://SUPORTEMAXXI40:8080/g5-senior-services/sapiens_Synccom_senior_g5_co_mcm_ven_conhecimentotransporte/GravarCTRC");

			// Propriedades da Mensagem SOAP
			conn.setRequestProperty("Type","Request-Response");
			conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
			conn.setRequestProperty("Accept-Encoding","gzip,deflate");		
			conn.setRequestProperty("User-Agent","Jakarta Commons-HttpClient/3.1");

			// Canal de Saída da Requisição
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());  
			
			// Mensagem no Formato SOAP
			String xml = 	
			" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.senior.com.br\">"+
			  " <soapenv:Body>"+
	   			" <ser:GravarCTRC_3>"+
	   			  " <user>senior1</user>"+
	   			  " <password>senior1</password>"+
	   			  " <encryption>0</encryption>"+
	   			  " <parameters>"+
	   				" <dadosCTRC>"+
	   	              " <tipGer>MAN</tipGer>"+
	   	              " <tipSer>0</tipSer>"+
	   	              " <codEmp>10</codEmp>"+
	   	              " <codFil>1</codFil>"+
	   	              " <codSnf>CTE</codSnf>"+
	   	              " <fecNfv>S</fecNfv>"+
	   	              " <oriSer>P</oriSer>"+
	   	              " <codRem>9</codRem>"+
	   	              " <codDes>10</codDes>"+
	   	              " <cifFob>F</cifFob>"+
	   	              " <numNfv></numNfv>"+
	   	              " <tnsSer>6360</tnsSer>"+
	   	              " <datEmi></datEmi>"+
	   	              " <codTom>10</codTom>"+
	   	              " <proPre>OD A S-500 27101921</proPre>"+
	   	              " <datCmc>30/05/2024</datCmc>"+
	   	              " <vlrFre>53487.33</vlrFre>"+
	   	              " <tipMod>ROD</tipMod>"+
	   	              " <tipFmt>1</tipFmt>"+
	   	              " <tipEmi>1</tipEmi>"+
	   	              " <tipCte>0</tipCte>"+
	   	              " <codCl3>9</codCl3>"+
	   	              " <codCl4>10</codCl4>"+
	   	              " <indRet>S</indRet>"+
 
	   	              " <gridUsu>"+
	   	                " <CmpUsu>USU_TipMod</CmpUsu>"+
	   	                " <VlrUsu>2</VlrUsu>"+
				      " </gridUsu>"+   
	   	              " <gridUsu>"+  
	   	                " <CmpUsu>USU_BasAfm</CmpUsu>"+
	   	                " <VlrUsu>53487,33</VlrUsu>"+
					  " </gridUsu>"+
					  " <gridUsu>"+
	   	                " <CmpUsu>USU_VlrAfm</CmpUsu>"+
	   	                " <VlrUsu>21394,93</VlrUsu>"+
					  " </gridUsu>"+   
					  " <gridUsu>"+
	   	                " <CmpUsu>USU_NomNav</CmpUsu>"+
	   	                " <VlrUsu>EDL-VI -001021719-3</VlrUsu>"+
					  " </gridUsu>"+  
					  " <gridUsu>"+					
	   	                " <CmpUsu>USU_NomBal</CmpUsu>"+
	   	                " <VlrUsu>B/T EDL-XXI-0010223649</VlrUsu>"+
					  " </gridUsu>"+  
					  " <gridUsu>"+
	   	                " <CmpUsu>USU_CodDir</CmpUsu>"+
	   	                " <VlrUsu>L</VlrUsu>"+
					  " </gridUsu>"+   
					  " <gridUsu>"+
	   	                " <CmpUsu>USU_CodIri</CmpUsu>"+
	   	                " <VlrUsu>ABC1234567</VlrUsu>"+
	   	              " </gridUsu>"+ 
	   	            
	   	              " <GridCmp>"+
					    " <SeqCct>1</SeqCct>"+
				        " <DatEmi>02/04/2024</DatEmi>"+
				        " <CodEdc>55</CodEdc>"+
				        " <CodSel>3</CodSel>"+
				        " <NumNft>15999</NumNft>"+
				        " <VlrTot>436480.00</VlrTot>"+
				        " <QtdMer>100000</QtdMer>"+
				        " <ChvNel>13240433337122008535550030000159991447941434</ChvNel>"+
				        " <ComNat>6659</ComNat>"+
				        " <TipDoc>N</TipDoc>"+
				        " <InfQuantidade>"+
					      " <SeqIqc>1</SeqIqc>"+
					      " <MedCte>04</MedCte>"+
					      " <TipMed>LITRAGEM</TipMed>"+
					      " <QtdMed>100000</QtdMed>"+
				        " </InfQuantidade>"+
				        " <GridUnt/>"+
					    " <GridUnc/>"+
				      " </GridCmp>"+
					
					  " <GridCmp>"+
					    " <SeqCct>2</SeqCct>"+
					    " <DatEmi>02/04/2024</DatEmi>"+
					    " <CodEdc>55</CodEdc>"+
					    " <CodSel>3</CodSel>"+
					    " <NumNft>16000</NumNft>"+
					    " <VlrTot>436480.00</VlrTot>"+
					    " <QtdMer>100000</QtdMer>"+
					    " <ChvNel>13240433337122008535550030000160001552137049</ChvNel>"+
					    " <ComNat>6659</ComNat>"+
					    " <TipDoc>N</TipDoc>"+
					    " <InfQuantidade>"+
					      " <SeqIqc>1</SeqIqc>"+
					      " <MedCte>04</MedCte>"+
					      " <TipMed>LITRAGEM</TipMed>"+
					      " <QtdMed>100000</QtdMed>"+
					    " </InfQuantidade>"+
					    " <GridUnt/>"+
					    " <GridUnc/>"+
					  " </GridCmp>"+
					
					  " <GridCmp>"+
					    " <SeqCct>3</SeqCct>"+
					    " <DatEmi>02/04/2024</DatEmi>"+
					    " <CodEdc>55</CodEdc>"+
					    " <CodSel>3</CodSel>"+
					    " <NumNft>16001</NumNft>"+
					    " <VlrTot>436480.00</VlrTot>"+
					    " <QtdMer>100000</QtdMer>"+
					    " <ChvNel>13240433337122008535550030000160011127749788</ChvNel>"+
					    " <ComNat>6659</ComNat>"+
					    " <TipDoc>N</TipDoc>"+
					    " <InfQuantidade>"+
					      " <SeqIqc>1</SeqIqc>"+
					      " <MedCte>04</MedCte>"+
					      " <TipMed>LITRAGEM</TipMed>"+
					      " <QtdMed>100000</QtdMed>"+
					    " </InfQuantidade>"+
					    " <GridUnt/>"+
					    " <GridUnc/>"+
					  " </GridCmp>"+
					  
					  " <GridCmp>"+ 
					    " <SeqCct>4</SeqCct>"+
					    " <DatEmi>02/04/2024</DatEmi>"+
					    " <CodEdc>55</CodEdc>"+
					    " <CodSel>3</CodSel>"+
					    " <NumNft>16002</NumNft>"+
					    " <VlrTot>448011.80</VlrTot>"+
					    " <QtdMer>102642</QtdMer>"+
					    " <ChvNel>13240433337122008535550030000160021296975286</ChvNel>"+
					    " <ComNat>6659</ComNat>"+
					    " <TipDoc>N</TipDoc>"+
					    " <InfQuantidade>"+
					      " <SeqIqc>1</SeqIqc>"+
					      " <MedCte>04</MedCte>"+
					      " <TipMed>LITRAGEM</TipMed>"+
					      " <QtdMed>102642</QtdMed>"+
					    " </InfQuantidade>"+
					    " <GridUnt/>"+
					    " <GridUnc/>"+
	   	              " </GridCmp>"+	
	   	            
	   	              " <gridObs>"+
					    " <seqObs>1</seqObs>"+
					    " <tipObs>A</tipObs>"+
					    " <obsNfv>Viagem: 31/24Base Calculo ICMS 53.487,33 ICMS 12,00 6.418,48 Calculo Presumido 20,00 % 1.283,70 ICMS Subst. Tributaria 5.134,78 - O ICMS Sera Pago Pelo Tomador de Servico. EMBARCACAO BENEFICIADA P/ ART. 38 LEI 10.893: R$ 16046,20 REBOCADOR: EDL-VI-001021719-3 BALSA: B/T EDL-XXI-0010223649 FRETE L&#205;QUIDO R$ 47.068,85 BT EDL XXI</obsNfv>"+
					    " <usuGer>22</usuGer>"+
					    " <datGer>01/05/2024</datGer>"+
					    " <horGer>600</horGer>"+
					    " <indObs>1</indObs>"+
	   	              " </gridObs>"+
	   	            " </dadosCTRC>"+
	   		      " </parameters>"+
	   		    " </ser:GravarCTRC_3>"+
	   		  " </soapenv:Body>"+
	   		" </soapenv:Envelope>";

		    wr.write(xml); 
	        wr.flush(); 

	       System.out.println("Requisição >>  "+conn.getOutputStream());

	        // Leitura da Resposta do Serviço
	       BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        // Leituras das Linhas da Resposta
	        while (rd.ready()){
	        	msgRetorno += rd.readLine();
	        }

	        wr.close();  
	        rd.close(); 
	        conn.getInputStream().close();

	        System.out.println("Resposta >>  \n"+ msgRetorno);	        
		} 
		catch (IOException e) {			
			e.printStackTrace();			
	    } finally {
	    	System.out.println("Fim");
		}

	}

	private static String getValueIfPresent(Element element, String tagName) {
		NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        } else {
            return "Não encontrado";
        }
	}	
}

