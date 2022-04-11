library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity divisor_100kHz is
    Port ( clk_in : in std_logic;
           clk_out : out std_logic;
           ce : in std_logic;
           reset : in std_logic;
           sclk : out std_logic);
end divisor_100kHz;

architecture Behavioral of divisor_100kHz is

signal count: integer range 0 to 49:=0;
signal clk_out_aux: std_logic:='0';

begin

clk_out <= clk_out_aux;
sclk <= clk_out_aux;

process (reset,clk_in)
begin
    if reset = '1' then     clk_out_aux <='0';
                                count <= 0;
     elsif
        clk_in='1' and clk_in'event then
            if ce = '1' then
                if count = 49 then clk_out_aux <= not clk_out_aux;
                                         count <= 0;
                else count <= count+1;
                end if;
            end if;
    end if;
end process;
end Behavioral;