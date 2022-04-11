library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;


entity contador_0_8 is
    Port ( reset : in STD_LOGIC;
           reset_cont : in STD_LOGIC;
           ce : in STD_LOGIC;
           clk : in STD_LOGIC;
           q : out STD_LOGIC_VECTOR (2 downto 0);
           overflow : inout STD_LOGIC);

end contador_0_8;


                architecture Behavioral of contador_0_8 is

                signal q_t : STD_LOGIC_VECTOR(2 downto 0);
    
                begin
                     q <= q_t;
    
                    process(clk)
                    begin 
                    if (clk'event and clk = '1') then
                        if (reset_cont ='1') then
                            q_t <= "000";
                            overflow <= '0';
                        end if;
                        if (reset = '1') then
                            q_t <= "000";
                       
                        elsif(ce = '1') then 
                            q_t <= q_t+1;
                        else
                            q_t<=q_t;
                        end if;

                        if(q_t = "111") then
                            overflow <= '1';              
                        else
                            overflow <= '0';
                        end if;
                    end if;
                    end process;
                end Behavioral;