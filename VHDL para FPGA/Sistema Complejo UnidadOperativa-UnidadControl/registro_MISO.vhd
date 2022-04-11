library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity registro_MISO is
    Port ( d : in STD_LOGIC;
           ce : in STD_LOGIC;
           clk : in STD_LOGIC;
           reset : in STD_LOGIC;
           q : out STD_LOGIC_VECTOR (7 downto 0));
end registro_MISO;

architecture Behavioral of registro_MISO is


signal qAux:std_logic_vector (7 downto 0);

begin
    process (clk, reset,ce)
    begin       
      if clk'event and clk='1' then
      if reset ='1' then
         qAux<="00000000";
      elsif ce = '1' then
         qAux(7 downto 1)<=qAux(6 downto 0);
            qAux(0)<=d;
      end if;
   end if;
    end process;
q<=qAux;

end Behavioral;