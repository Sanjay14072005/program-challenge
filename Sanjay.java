class Sanjay 
{
	public static void main(String args[] )
	{
        int prices[] ={ 4 ,10, 9, 8, 6 };
		int min =prices[0];
        int m_profit=0;
        for( int  i = 1 ; i < prices.length ; i++)   
        {
        int profit=prices[i] -min;
        m_profit= (profit > m_profit? profit : m_profit);
        min =  (min > prices[i] ? prices[i] : min);
        }
        System.out.println( m_profit);
	}
}