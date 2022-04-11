library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity unidad_control is
    Port ( clk : in STD_LOGIC;
           reset : in STD_LOGIC;
           FA : in STD_LOGIC;
           overflow : in STD_LOGIC;
           FD : in STD_LOGIC;
          salida_rs : in STD_LOGIC;
           

           SS : out STD_LOGIC;
           ce_DIVISOR : out STD_LOGIC;
           load_MOSI : out STD_LOGIC;
           ce_CONTADOR : out STD_LOGIC;
           ce_MOSI : out STD_LOGIC;
           ce_MISO : out STD_LOGIC;
           load_rx : out STD_LOGIC;
           reset_cont : out STD_LOGIC;
           reset_rs : out   std_logic;
           tx_rx_end : out STD_LOGIC);
end unidad_control;

architecture Behavioral of unidad_control is

    TYPE tipo_estado IS (E0, E1, E2, E3, E4, E5,E6);
    signal Estado_actual : tipo_estado;
    signal Estado_siguiente : tipo_estado;

begin

    Registro_estado: process (clk, reset)
    begin
        if reset = '1' then
            Estado_actual <= E0;
        elsif (clk'event and clk = '1') then
            Estado_actual <= Estado_siguiente;
        end if;
    end process Registro_estado;

    Combinacional: process (FA,FD,salida_rs,overflow,Estado_actual)
    begin
        Estado_siguiente <= Estado_actual;
                load_MOSI <= '0';
                ce_MOSI <= '0';
                ce_MISO <= '0';
                ce_CONTADOR <= '0';
                ce_DIVISOR <= '1';
                SS <= '0';
                load_rx <= '0';
                reset_cont <= '0';
                tx_rx_end <= '0';
                reset_rs <= '0';
        case Estado_actual is
when E0 =>    
              SS <= '1';
              ce_DIVISOR <= '0';          
              if (salida_rs = '1') then
                    Estado_siguiente <= E1;
                end if;
when E1 =>
                load_MOSI <= '1';
                reset_rs <= '1';
                Estado_siguiente <= E2;
when E2 =>
                    if (FA = '1') then
                    Estado_siguiente <= E3;
                end if;
when E3 =>
                ce_MISO <= '1';
                Estado_siguiente <= E4;
when E4 =>
                 if (FD = '1') then
                    Estado_siguiente <= E5;
                end if;                   
when E5 =>
                ce_CONTADOR <= '1';
                ce_MOSI <= '1';
              if (overflow = '1') then
                    Estado_siguiente <= E6;
              else Estado_siguiente <= E2;
                end if;                    
               
when E6 =>
               reset_cont <= '1';
               tx_rx_end <= '1';
               load_rx <= '1';
               Estado_siguiente <= E0;
when others =>
                Estado_siguiente <= E0;
        end case;
    end process Combinacional;
end Behavioral;