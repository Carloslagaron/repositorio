library IEEE;

use IEEE.STD_LOGIC_1164.all;

entity biestable_d is
    port(
        reset : in STD_LOGIC;
        clk : in STD_LOGIC;        
        d : in STD_LOGIC;
        q : out STD_LOGIC);
    end biestable_d;

architecture behavioral of biestable_d is
begin
    process(clk, reset)
    begin
        if (reset = '1') then
            q <= '0';
        elsif(clk'event and clk='1') then
            q<=not(d);
        end if;
    end process;
end behavioral;