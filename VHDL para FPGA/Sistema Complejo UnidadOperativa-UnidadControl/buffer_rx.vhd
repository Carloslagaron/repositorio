library IEEE;
use IEEE.STD_LOGIC_1164.ALL;



entity buffer_rx is
    Port ( d : in STD_LOGIC_VECTOR (7 downto 0);
           ce: in STD_LOGIC;
           clk : in STD_LOGIC;
           reset : in STD_LOGIC;
           q : out STD_LOGIC_VECTOR (7 downto 0));
end buffer_rx;

architecture Behavioral of buffer_rx is


begin
    process (clk, reset,ce)
    begin

        if reset='1' then q<="00000000";
        elsif(clk'event and clk='1') then
        if(ce='1') then
            q<=d;
        end if;
         end if;
    end process;

end Behavioral;