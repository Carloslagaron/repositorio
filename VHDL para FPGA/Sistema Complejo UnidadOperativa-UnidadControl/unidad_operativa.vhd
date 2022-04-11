library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity unidad_operativa is
    Port ( load_tx : in STD_LOGIC;
           load_rx : in STD_LOGIC;
           data_tx : in STD_LOGIC_VECTOR (7 downto 0);
           data_rx : out STD_LOGIC_VECTOR (7 downto 0);
           reset_rs : in std_logic;
           clk : in STD_LOGIC;
           reset : in STD_LOGIC;
           reset_cont : in STD_LOGIC;
           load_MOSI : in STD_LOGIC;
           ce_CONTADOR : in STD_LOGIC;
           ce_MOSI : in STD_LOGIC;
           ce_MISO : in STD_LOGIC;
           ce_DIVISOR : in STD_LOGIC;
           MISO : in STD_LOGIC;
           overflow : inout STD_LOGIC;
           contador_out: out STD_LOGIC_VECTOR(2 downto 0);
           MOSI : out STD_LOGIC;
           FA : out STD_LOGIC;
           FD : out STD_LOGIC;
           buffer_empty : out STD_LOGIC;
           salida_rs : out STD_LOGIC;          
           sclk : out STD_LOGIC);
end unidad_operativa;

architecture Behavioral of unidad_operativa is

    signal reset_buffer_tx : STD_LOGIC;
    signal entrada : STD_LOGIC;
    signal entrada_aux : std_logic;
    signal det_buffer_aux : std_logic;
    signal entrada_MOSI : STD_LOGIC_VECTOR(7 downto 0);
    signal salida_MISO : STD_LOGIC_VECTOR(7 downto 0);
    
    

    

    
    Component registro_MOSI Port (
            d : in std_logic_vector(7 downto 0);
            load_MOSI : in std_logic;
            ce : in std_logic;
            clk : in std_logic;
            reset : in std_logic;           
            q : out std_logic);
    end Component;
    
     Component registro_MISO Port (
            d : in std_logic;
            ce : in std_logic;
            clk : in std_logic;
            reset : in std_logic;           
            q : out std_logic_vector (7 downto 0));
    end Component;
    
    Component buffer_tx Port (
            d : in std_logic_vector(7 downto 0);
            ce : in std_logic;
            clk : in std_logic;
            reset : in std_logic;
            q : out std_logic_vector(7 downto 0));
    end Component;
    
    Component buffer_rx Port (
            d : in std_logic_vector(7 downto 0);
            ce : in std_logic;
            clk : in std_logic;
            reset :in std_logic;
            q : out std_logic_vector(7 downto 0)
            );
    end Component;
    
    Component contador_0_8 Port (
            reset : in std_logic;
            reset_cont : in std_logic;
            ce : in std_logic;
            clk : in std_logic;
            q : out std_logic_vector(2 downto 0);
            overflow : inout std_logic);
    end Component;
    
    Component divisor_100kHz Port (
           clk_in : in std_logic;
           clk_out : out std_logic;
           ce : in std_logic;
           reset : in std_logic;
           sclk : out std_logic);
    end Component;
    
    Component detector_flancos Port (
           entrada : in STD_LOGIC;
           clk : in STD_LOGIC;
           reset : in STD_LOGIC;
           FA : out STD_LOGIC;
           FD : out STD_LOGIC);
    end Component;
    
    Component biestable_sr Port (
           reset_rs : in std_logic;
           s : in std_logic;
           clk : in std_logic;
           salida_rs : out std_logic;
           det_buffer : out std_logic);
    end Component;
    
    Component biestable_d  Port (
           reset : in std_logic;
           clk : in std_logic;
           d : in std_logic;
           q : out std_logic);
    end Component;
    
begin

    RMOSI: registro_MOSI Port Map (
            d => entrada_MOSI,
            load_MOSI => load_MOSI,
            clk => clk,
            ce => ce_MOSI,
            reset => reset,
            q => MOSI);
           
      RMISO: registro_MISO Port Map (
            d => MISO,
            clk => clk,
            ce => ce_MISO,
            reset => reset,
            q => salida_MISO);
            
                       
    BUFTX: buffer_tx Port Map (
            d => data_tx,
            ce => load_tx,
            clk => clk,
            reset => reset,
            q => entrada_MOSI);
           
    BUFRX: buffer_rx Port Map (
            d => salida_MISO,
            ce => load_rx,
            clk => clk,
            reset => reset,
            q => data_rx);
           
    CONT: contador_0_8 Port Map (
            ce => ce_CONTADOR,
            reset_cont => reset_cont,
            reset => reset,
            clk => clk,
            q => contador_out,
            overflow => overflow);
            
     DIV: divisor_100kHz Port Map (
            clk_in => clk,
            ce => ce_DIVISOR,
            reset => reset,
            clk_out => entrada_aux,
            sclk => sclk);
      
     DETF: detector_flancos Port Map (
            entrada => entrada_aux,
            clk => clk,
            reset => reset,
            FA => FA,
            FD => FD);
            
     BSR: biestable_sr Port Map (
           s => load_tx,
           reset_rs =>reset_rs,
           clk => clk,
           salida_rs => salida_rs,
           det_buffer => det_buffer_aux);
          
     BD: biestable_d Port Map (
           reset => reset,
           clk => clk,
           d => det_buffer_aux,
           q => buffer_empty);
          
                    
end Behavioral;
