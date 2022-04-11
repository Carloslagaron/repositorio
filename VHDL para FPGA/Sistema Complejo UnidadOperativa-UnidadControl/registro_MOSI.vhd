library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity registro_MOSI is
    Port ( d : in STD_LOGIC_vector(7 downto 0);
           load_MOSI : in STD_LOGIC;
           ce : in STD_LOGIC;
           clk : in STD_LOGIC;
           reset : in STD_LOGIC;
           q : out STD_LOGIC);
end registro_MOSI;

architecture Behavioral of registro_MOSI is


       signal tmp : std_logic_vector(7 downto 0);


begin
  q<=tmp(7);  
    process (clk)
begin
   if clk'event and clk='0' then
      if reset ='1' then
         tmp <= (others => '0');
      elsif load_MOSI = '1' then
         tmp <= d;
      elsif ce = '1' then
         tmp <= tmp(6 downto 0) & '0';
      end if;
   end if;
end process;



end Behavioral;