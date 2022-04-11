----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 04.10.2021 18:36:56
-- Design Name: 
-- Module Name: biestable_sr - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity biestable_sr is
    Port ( reset_rs : in STD_LOGIC;
           s : in STD_LOGIC;
           clk : in STD_LOGIC;
           salida_rs : out STD_LOGIC;
           det_buffer : out STD_LOGIC);
end biestable_sr;

architecture Behavioral of biestable_sr is

    signal q_aux: std_logic:='0';

begin
    salida_rs <=q_aux;
    det_buffer <= q_aux;
process(clk)
begin
    
    if (clk 'event and clk='1') then
        if s = '1' then
           q_aux <= '1';
       end if;
    if reset_rs = '1' then
       q_aux <= '0';
    end if;
    end if;
end process;
end Behavioral;