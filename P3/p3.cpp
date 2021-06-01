#include<stdio.h>
#include<iostream>
#include<math.h>
 
using namespace std;

string binarygen(long long int num){
    string bin = "";
    while (num){
        if (num & 1)
            bin = "1" + bin;
        else
            bin = "0" + bin;
        num = num>>1;
    }
    return bin;
}
 
long long int decimalgen(string bin){
    long long int num = 0;
    for (int i=0; i<bin.length(); i++){
        if (bin.at(i)=='1')
            num += 1 << (bin.length() - i - 1);
    }
    return num;
}
string xorto1(string a, string b)
{
     
    string result = "";
     
    int n = b.length();
     
    for(int i = 1; i < n; i++)
    {
        if (a[i] == b[i])
            result += "0";
        else
            result += "1";
    }
    return result;
}
string divmod(string divident, string divisor)
{
     
    int pick = divisor.length();
     
    string tmp = divident.substr(0, pick);
     
    int n = divident.length();
     
    while (pick < n)
    {
        if (tmp[0] == '1')
         
            tmp = xorto1(divisor, tmp) + divident[pick];
        else
         
            tmp = xorto1(std::string(pick, '0'), tmp) +
                  divident[pick];
                   
        pick += 1;
    }
     
    if (tmp[0] == '1')
        tmp = xorto1(divisor, tmp);
    else
        tmp = xorto1(std::string(pick, '0'), tmp);
         
    return tmp;
} 
string CRC(string dataword, string generator){
    int l_gen = generator.length();
    long long int gen = decimalgen(generator);
 
    long long int dword = decimalgen(dataword);
 
    long long int dividend = dword << (l_gen-1);      
 
    int shft = (int) ceill(log2l(dividend+1)) - l_gen; 
    long long int rem;
 
    while ((dividend >= gen) || (shft >= 0)){
 
        rem = (dividend >> shft) ^ gen;               
        dividend = (dividend & ((1 << shft) - 1)) | (rem << shft);
 
        shft = (int) ceill(log2l(dividend + 1)) - l_gen;
    }
 
    long long int codeword = (dword << (l_gen - 1)) | dividend;
    return binarygen(dividend);
}
 
int main(){
     cout<<"Enter dataword and generator polynomial"<<endl;
    string dataword, g;
    cin>>dataword>>g ;
   int n=g.size();
   if(g[n-1]==0)
    {
        cout<<"Polynomial divisible by x"<<endl;
        return 0;
    }
    int sum=0;
    int t=1;
    for(int i=0;i<n;i++)
    {
        if((n-i-1)%2!=0)
        {
           t=-1;
        }
        sum=sum+(t*(g[i]-'0'));
    }
    if(sum==0)
    {
        cout<<"Polynomial divisible by x+1"<<endl;
        return 0;
    }
   int x=1;
   string cw="";
    while(x!=4)
   {
   cout<<"Enter 1 to generate Codeword or 2 to verify or 3 to alter a bit of dataword or 4 to exit"<<endl;    
   cin>>x;
    if(x==1)
    {
        
        string rem=CRC(dataword, g);
        cw=dataword+CRC(dataword, g);
       cout<<"Codeword : "<<cw<<endl;
    }
    else if (x==2)
    {
        cout<<"Remainder : "<<divmod(cw,g)<<endl;
        if(divmod(cw,g)=="0"||divmod(cw,g)=="00000"||divmod(cw,g)=="00"||divmod(cw,g)=="000"||divmod(cw,g)=="0000"||divmod(cw,g)=="000000")
         cout<<"verified"<<endl;
        else
         cout<<"error in transmission"<<endl; 
    }
    else if (x==3)
    {
        cout<<"Enter bit position to be altered"<<endl;
        int y;
        cin>>y;
        if(cw[y]=='1')
         {
             cw[y]='0';
         }
        else
        {
            cw[y]='1';
        } 
        cout<<"Bit at position "<<y<<" is altered"<<endl;
    }
    else 
    { 
      return 0;
    }
   }return 0;
}