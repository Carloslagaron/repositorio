library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity detector_flancos is
    Port ( entrada : in std_logic;
           clk : in std_logic;
           reset : in std_logic;
           FA : out std_logic; -- flanco ascendente
           FD : out std_logic -- flanco descendente
				);
end detector_flancos;

architecture Behavioral of detector_flancos is

signal entrada_t_1: std_logic:='0';
signal fa_aux : std_logic:='0'; -- flanco ascendente
signal fd_aux : std_logic:='0'; -- flanco descendente
signal entrada_s_aux : std_logic:='0'; -- variable sincronizada

begin

FA <= fa_aux;
FD <= fd_aux;

process (reset,clk,entrada_s_aux,entrada_t_1,entrada)
begin
	if reset = '1' then 	entrada_s_aux <= '0';
								entrada_t_1 <= '0';
	elsif clk = '1' and clk'event then entrada_t_1 <= entrada_s_aux;
												entrada_s_aux <= entrada;
	end if;

	fa_aux <= entrada_s_aux and not entrada_t_1;
	fd_aux <= not entrada_s_aux and entrada_t_1;

end process;

end Behavioral;
