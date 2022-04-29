/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

/**
 *
 * @author mutsu
 */
public class Lexico {
    final int TOKREC =7;
    final int MAXTOKENS =500;
    String [] _lexemas;
    String [] _tokens;
    String _lexema;
    int _noTokens;
    int [] _i = {0};
    int _iniToken;
    Automata oAFD;

public int NoTokens(){
return _noTokens;
}    

public String[] Tokens(){
return _tokens;
}

public String[] Lexemas(){
return _lexemas;
}
 
public Lexico(){
_lexemas = new String[MAXTOKENS];
_tokens = new String[MAXTOKENS];
oAFD = new Automata();
_i[0] = 0;
_iniToken = 0;
_noTokens = 0;

}

public void Inicia()
{
_i[0] = 0;
_iniToken = 0;
_noTokens = 0;
}
    
public void Analiza(String texto){
boolean recAuto;
int noAuto;
while(_i[0] < texto.length()){
    recAuto = false;
    noAuto=0;
for(;noAuto<TOKREC&&!recAuto;)
    if(oAFD.Reconoce(texto,_iniToken, _i,noAuto))
        recAuto=true;
    else 
        noAuto++;

    if(recAuto){
    _lexema = texto.substring(_iniToken, _i[0]);
    switch (noAuto){
        case 0 : //_tokens[_noTokens] = "delim";
        break;
        
        case 1 : _tokens[_noTokens] = "id";
        
        break;
        
        case 2 : _tokens[_noTokens] = "opasig";
        break;
        
        case 3 : _tokens[_noTokens] = "oparit";
        break;
        
        case 4 : _tokens[_noTokens] = "num";
        break;
        
        case 5 : _tokens[_noTokens] = "sep";
        break;
        
        case 6 : _tokens[_noTokens] = "terminst";
        break;
    
    }
    if(noAuto > 0)
        _lexemas[_noTokens++] = _lexema;
    }
    else
    _i[0]++;
    _iniToken = _i[0];
    
        
    }
}
    
}
